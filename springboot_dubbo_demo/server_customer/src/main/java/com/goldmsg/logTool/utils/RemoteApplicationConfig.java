package com.goldmsg.logTool.utils;

import com.goldmsg.levam.base.tools.utils.PropertiesLoader;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

import static org.springframework.boot.context.config.ConfigFileApplicationListener.CONFIG_NAME_PROPERTY;

/**
 * 远程加载服务的配置文件
 * Created with IntelliJ IDEA
 * Created by HEQI
 * DATE : 2017/8/11.
 * TIME : 10:12
 * EMAIL : qhs_dream@163.com
 */
public class RemoteApplicationConfig {

    private static final Logger LOGGER = Logger.getLogger(RemoteApplicationConfig.class);

    public static String DUBBO_REGISTRY_ADDRESS = "dubbo.registry.address";

    public static String EXTEND_CONFIG_LIST = "spring.config.location";

    /**
     * 加载远程的配置文件，并设置默认的CONFIG_NAME_PROPERTY防止springboot自动加载默认配置文件
     * @param   urlStr    远程配置文件地址
     * @return  配置类
     * @throws IOException
     */
    public static Properties loadProperties(final String urlStr) throws IOException {
        Properties properties = loadProperties2(urlStr);
        /**
         * 最后，增加默认的CONFIG_NAME_PROPERTY属性，防止springboot默认去读取application.properties文件
         * 这样会导致:remote:无法识别的错误
         */
        properties.setProperty(CONFIG_NAME_PROPERTY, "extend");

        return properties;
    }

    /**
     * 加载远程的配置文件
     * @param   urlStr    远程配置文件地址
     * @return  配置类
     * @throws IOException
     */
    public static Properties loadProperties2(final String urlStr) throws IOException {

        InputStream inputStream = null;

        String zkAddress = "";

        try {
            Properties properties = new Properties();
            URL url = new URL(urlStr);
            inputStream = new BufferedInputStream(url.openStream());
            properties.load(new InputStreamReader(inputStream, "utf-8"));
            // 初始化zookeeper地址
            zkAddress = String.valueOf(properties.get(DUBBO_REGISTRY_ADDRESS));
            if (!StringUtils.isEmpty(zkAddress) && !zkAddress.equals("null")) {
                /**
                 * 获取配置文件中含有自定义通配符“:remote:{值}”的键值对，根据“值”从zookeeper获取“值”节点下值，并加载到properties文件中。
                 * */
                properties = setRemoteParameter(properties, zkAddress);
            }

            return properties;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public static Properties loadProperties3(final String urlStr) throws Exception {

        try{
            //加载原始配置文件
            List<String> urlList = new ArrayList();
            urlList.add(urlStr);
            PropertiesLoader loader = new PropertiesLoader();
            loader.loadFromURLList(urlList);

            //加载拓展配置文件
            List<String> extendFileList = Arrays.asList(loader.getString(EXTEND_CONFIG_LIST).split(","));
            if(0 != extendFileList.size())
                loader.appendFromFileList(extendFileList);

            String zkHost = loader.getString(DUBBO_REGISTRY_ADDRESS);
            if(null == zkHost)              return loader.getProperties();
            if(true == zkHost.isEmpty())    return loader.getProperties();

            return setRemoteParameter(loader.getProperties(), zkHost);
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw e;
        }

    }

    /**
     * @param properties
     * @return 获取配置文件中含有自定义通配符“:remote:{值}”的键值对，根据“值”从zookeeper获取“值”节点下值，并加载到properties文件中。
     */
    private static Properties setRemoteParameter(Properties properties, String zkHost) {
        CuratorFramework zkclient = null;
        try {
            // 初始zookeeper连接
            zkclient = initializerZKclient(zkHost);
            // 临时存放zookeeper的参数值
            Map<Object, Object> keyValue = new LinkedHashMap<>();

            Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
            List<BasicNameValuePair> l = new ArrayList<>();

            for (Map.Entry<Object, Object> entry : entrySet) {
                String key = String.valueOf(entry.getKey()).trim();
                String value = String.valueOf(entry.getValue()).trim();
                String value2 = new String(value);

                while (value.contains(":remote:{")) {
                    int idx = value.indexOf(":remote:{");
                    int idxEnd = value.indexOf("}", idx);

                    String path = value.substring(idx + ":remote:{".length(), idxEnd);

                    if (null == zkclient.checkExists().forPath(path)) {
                        throw new RuntimeException(path + "\t节点不存在，请初始化节点！！！");
                    } else {
                        String regex = value.substring(idx, idxEnd + 1);

                        // 获取当前节点下的数据
                        byte[] data = zkclient.getData().forPath(path);
                        // 如果节点值为null值不构造remoteValue
                        String remoteValue = null;
                        if (data != null) {
                            remoteValue = new String(data, "UTF-8").trim();
                        }

                        l.add(new BasicNameValuePair(regex, remoteValue));
                    }

                    value = value.substring(idxEnd + 1);
                }

                for (BasicNameValuePair nv : l) {
                    // 如果节点值为null值，进入下一次循环
                    if (nv.getValue() == null) {
                        continue;
                    }
                    value2 = value2.replace(nv.getName(), nv.getValue());
                }
                keyValue.put(key, value2);
            }

            /**
             * 把从zookeeper获取的值覆盖到Properties
             * */
            Set<Map.Entry<Object, Object>> entries = keyValue.entrySet();
            for (Map.Entry<Object, Object> entry : entries) {
                properties.put(entry.getKey(), entry.getValue());
            }
            return properties;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (zkclient != null) {
                zkclient.close();
            }
        }
    }

    /**
     * 初始化zookeeper连接
     *
     * @param zkHost zookeeper的地址
     * @return
     */
    private static CuratorFramework initializerZKclient(String zkHost) {
        // 重试机制。baseSleepTimeMs:重试间隔时间基数，maxRetries:是重试次数
        RetryPolicy rp = new ExponentialBackoffRetry(1000, 5);
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        CuratorFramework zkclient = builder.connectString(zkHost)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .canBeReadOnly(false)
                .retryPolicy(rp)
                .build();
        zkclient.start();
        return zkclient;
    }

}
