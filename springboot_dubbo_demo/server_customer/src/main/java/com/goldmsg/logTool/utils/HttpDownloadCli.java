package com.goldmsg.logTool.utils;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 *  HTTP下载文件客户端，使用HttpRequest实现HTTP连接
 */
public class HttpDownloadCli {

    public static final Logger log  = LoggerFactory.getLogger(HttpDownloadCli.class);
    /**
     *  HTTP GET方法下载
     * @param url
     */
    public HttpDownloadCli(String url){
        this.Url = url;
    }

    /**
     * 返回http 返回码
     * @return
    **/
    public  int getResponseCode(){
        int  resCode = 200;
        try {
            if(null == httpURLConnection){
                return 500;
            }
            resCode = httpURLConnection.getResponseCode();

        } catch (IOException e) {
            log.error("HttpDownloadCli getResponseCode IOException happen : " + e);
            return 500;
        }catch (Exception e){
            log.error("HttpDownloadCli getResponseCode Exception happen : " + e);
            return 500;
        }
        return resCode;
    }

    /**
     *  获取http 返回信息，用于判断是不是文件不存在
     *  @return String
    **/
    public String getResponseMessage(){

        String resMsg = null;
        try {
            if(null == httpURLConnection){
                return resMsg;
            }
            resMsg = httpURLConnection.getResponseMessage();

        } catch (IOException e) {
            log.error("HttpDownloadCli getResponseMessage IOException happen : " + e);
            return resMsg;
        }catch (Exception e){
            log.error("HttpDownloadCli getResponseMessage Exception happen : " + e);
            return resMsg;
        }
        return resMsg;
    }

    /**
     *  返回HTTP输入流，将从此流读取文件. 在使用完成后需要调用BufferedInputStream.close(),用来释放网络资源
     * @return
     */
    public BufferedInputStream getInputStream(){
        if(false == connect()){

            return null;
        }
        BufferedInputStream respons = null;
        try {
            if(null == httpURLConnection){
                return null;
            }
            respons = new BufferedInputStream(httpURLConnection.getInputStream());

        } catch (IOException e) {
            log.error("HttpDownloadCli getInputStream IOException happen : " + e);
        }catch (Exception e){
            log.error("HttpDownloadCli getInputStream Exception happen : " + e);
        }
        return respons;
    }


    /**
     *  获取下载时的文件名
     * @return
     */
    public String getFileName(){
        if(null ==  httpURLConnection){
            return null;
        }

        String fileName = null;
        String tempName = httpURLConnection.getHeaderField("Content-Disposition");
        if(null == tempName){
            log.info("HttpDownloadCli get tempName is null ! " );
            return null;
        }
        try {
            fileName = new String(tempName.getBytes("iso-8859-1"), "GBK");
        }catch (UnsupportedEncodingException e){
            log.error("HttpDownloadCli getInputStream UnsupportedEncodingException happen : " + e);
            return null;
        }catch (Exception e){
            log.error("HttpDownloadCli getInputStream Exception happen : " + e);
            return null;
        }

        if(null == fileName){
            return null;
        }else{
            String[] file = fileName.split("=");
            if(file.length < 2){
                return null;
            }
            return file[1];
        }
    }

    /**
     *  获取下载时的文件大小
     * @return
     */
    public long getFileSize(){
        if(null ==  httpURLConnection){
            return -1;
        }

        long    size       = 0;
        String SizeStr   = null;
        SizeStr            = httpURLConnection.getHeaderField("Content-Length");
        if(null == SizeStr || SizeStr.equals("")){
            return -1;
        }
        try{
            size         = Long.parseLong(SizeStr);
        }catch (NumberFormatException e){
            log.error("getFilesize NumberFormatException e happen " + e);
            return -1;
        }catch (Exception e){
            log.error("getFilesize Exception  happen " + e);
            return -1;
        }

        return size;
    }

    /**
     *  判断服务器是否支持断点续传
     * @return   boolean
     */
    public boolean isSupportPointDownload(){
        if(null ==  httpURLConnection){
            return false;
        }

        boolean     retFlag         = false;
        String contentRange     = httpURLConnection.getHeaderField("Content-Range");
        if(null != contentRange){
            retFlag = true;
        }

        return retFlag;
    }

    /**
     *  设置http 请求头部信息
     *  @param key
     *  @param value
     */

    public boolean setRequestProperty(String key, String value)
    {
        if(null == map)
            map = new HashMap<String, Object>();

        map.put(key, value);
        return true;
    }

    /**
     *  连接服务器
     */
    public boolean connect()
    {
        try{
            URL urlRequest = new URL(Url);
            httpURLConnection = (HttpURLConnection)urlRequest.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(1000 * 120 * 2);
            httpURLConnection.setReadTimeout(1000 * 120 * 2);

            //设置http 请求头部
            if(null != map)
                for(String key : map.keySet())
                    httpURLConnection.setRequestProperty(key, map.get(key).toString());

            httpURLConnection.connect();
            return true;
        }catch (MalformedURLException e){
            log.error("HttpDownloadCli connect MalformedURLException happen : " + e);
        }catch (IOException e){
            log.error("HttpDownloadCli connect IOException happen : " + e);
        }catch (Exception e){
            log.error("HttpDownloadCli connect Exception happen : " + e);
        }
        return false;
    }

    /**
     *  断开连接
     */
    public void  disconnect()
    {
        if(null == httpURLConnection)
            return ;

        httpURLConnection.disconnect();
    }

    /**
     *  实际发送HTTP请求的对象
     */
    private HttpResponse httpResponse               = null;
    private HttpURLConnection httpURLConnection    = null;
    private String Url                               = null;
    private Map<String, Object> map                  = null;



    /**
     *  测试
     */
    public static void main(String[] argv){
        /**
         *  下载一个文件
         */
        if(true){
            String url = "http://192.168.56.98/disk0/20190606/44010000901281613467/chq2@2019-06-06_09-02-50.mp4";
            String[] tempName = url.split("/");
            System.out.println(tempName[tempName.length-1]);
            HttpDownloadCli httpDownloadCli = new HttpDownloadCli(url);
            httpDownloadCli.connect();
            System.out.println(httpDownloadCli.getFileName());
            System.out.println(httpDownloadCli.getFileSize());
            double size = (double) httpDownloadCli.getFileSize()/1024/1024;
            BufferedInputStream reader = httpDownloadCli.getInputStream();
            if (null == reader) {
                log.error("url(" + url + ") get input stream is null");
            }
            try {
                OutputStream fileOutputStreamTest = null;
                fileOutputStreamTest = new BufferedOutputStream(new FileOutputStream("E:\\test.mp4"));
//                FileOutputStream fileOutputStream = new FileOutputStream(httpDownloadCli.getFileName());
                byte[] inputBuffer = new byte[1024*1024*1024];
                int inputLen = 0;
                while((inputLen = reader.read(inputBuffer)) != -1){
                    fileOutputStreamTest.write(inputBuffer, 0, inputLen);
                }
            //关闭本地文件流
                try {
                    if (null != fileOutputStreamTest) {
                        fileOutputStreamTest.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }finally {

                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return ;
                }
            }
        }


        /**
         *  请求一段JSON
         */
//        if(false){
//            HttpRequest httpGetJson = new HttpRequest();
//            BufferedInputStream readerJson = httpGetJson.getRequest("http://192.168.10.156/gmvcs/rest/test?test=333");
//            try {
//                byte[] inputBuffer = new byte[1024*8];
//                int inputLen = 0;
//                while((inputLen = readerJson.read(inputBuffer)) != -1){
//                    String json = new String(inputBuffer);
//                    System.out.println(json);
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }finally {
//                try {
//                    readerJson.close();
//                } catch (IOException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                    return ;
//                }
//            }
//        }

    }//main
}
