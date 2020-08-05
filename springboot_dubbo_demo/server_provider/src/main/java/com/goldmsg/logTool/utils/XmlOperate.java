package com.goldmsg.logTool.utils;

/**
 * Created with IntelliJ IDEA.
 * User: KINKOO
 * Date: 14-4-22
 * Time: 上午10:49
 */

import org.dom4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author gxl
 * @version V1.0
 * @Title: TestDom4j.java
 * @Package
 * @Description: 解析xml字符串
 * @date 2012-11-20 下午05:14:05
 */
public  class XmlOperate {
    /**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */

    private static final Logger LOG = LoggerFactory.getLogger(XmlOperate.class);

    public static Properties props=new Properties();

    public static Map readStringXmlOut(String xml, List<String> filedList, String interfaceNode) throws DocumentException {
        Map map = new HashMap();
        List<Map> returnList = new ArrayList<Map>();
        Document doc;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            Iterator iter = rootElt.elementIterator("head"); // 获取根节点下的子节点head

            // 遍历head节点
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                String code = recordEle.elementTextTrim("code"); // 拿到head节点下的子节点code值
                String message = recordEle.elementTextTrim("message"); // 拿到head节点下的子节点message值
                String colname = recordEle.elementTextTrim("colname"); // 拿到head节点下的子节点colname值
                String rownum = recordEle.elementTextTrim("rownum"); // 拿到head节点下的子节点rownum值
                map.put("code", code == null ? "" : code);
                map.put("message", message == null ? "" : message);
                map.put("colname", colname == null ? "" : colname);
                map.put("rownum", rownum == null ? "" : rownum);
            }
            if (null != filedList) {
                //获取根节点下的子节点body
                Iterator iterss = rootElt.elementIterator("body");
                // 遍历body节点
                while (iterss.hasNext()) {
                    Element recordEless = (Element) iterss.next();
                    Iterator itersElIterator = recordEless.elementIterator(interfaceNode); // 获取子节点body下的子节点violation
                    // 遍历Header节点下的Response节点
                    while (itersElIterator.hasNext()) {
                        Map tempMap = new HashMap();
                        Element itemEle = (Element) itersElIterator.next();
                        Attribute id = itemEle.attribute("id");
                        for (String field : filedList) {
                            String value = itemEle.elementTextTrim(field);
                            tempMap.put("id", id.getValue().toString());
                            tempMap.put(field, value);
                        }
                        returnList.add(tempMap);
                    }
                    map.put(interfaceNode, returnList);
                }
            }
        } catch (DocumentException e) {
            throw e;
        }
        return map;
    }

    //传入Map写返回xml格式的String
    public static String writeStringXmlOut(String interfaceNode, Map writeMap) {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("GBK");
        Element root = document.addElement("root");
        Element secondNode = root.addElement(interfaceNode);
        for (Object o : writeMap.entrySet()) {
            Map.Entry entryTemp = (Map.Entry) o;
            Object keyTemp = entryTemp.getKey();
            Object valueTemp = entryTemp.getValue();
            valueTemp = valueTemp == null ? "" : valueTemp;
            try {
                valueTemp = URLEncoder.encode(valueTemp.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Element element = secondNode.addElement(keyTemp.toString()).addText(valueTemp.toString());
        }
        return document.asXML();
    }

    // 特殊字符替换
    public static String replace(String retValue) {
        Enumeration enumeration = props.propertyNames();
        // 替换全角空格为半角空格
        retValue = retValue.replaceAll("　", " ");
        retValue=retValue.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        while (enumeration.hasMoreElements()) {
            String key =(String)enumeration.nextElement();
            String value = props.getProperty(key);
            retValue = retValue.replaceAll(key, value);
        }
        return retValue;
    }

    public static String filte(String str,List<String> match,String pNodeName){
        List<String> matches=new ArrayList<String>(match.size()*2);
        add(match,matches);
        StringBuilder stringBuilder=new StringBuilder(str);
        int start=0;
        int end=0;
        boolean flag=false;
        for(int i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i)=='<'){
                start=i;
            }
            if(stringBuilder.charAt(i)=='>'){
                end=i;
                String nodeName=stringBuilder.substring(start, end + 1);
                if(nodeName.contains("</"+pNodeName)){
                    flag=false;
                }
                if(flag&&start<end){
                    if(!matches.contains(nodeName)){
                        stringBuilder.replace(start,end+1,nodeName.replace("<","&lt;").replace(">","&gt;"));
                    }
                }
                if(nodeName.contains("<"+pNodeName)){
                    flag=true;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static void add(List<String> match, List<String> matches) {
        for(String str:match){
            matches.add("<"+str+">");
            matches.add("</"+str+">");
        }
    }

    public static void main(String[] args) throws Exception {
/*        String xmlString="<root><node>women<我在></node></root>";*/
        // 下面是需要解析的xml字符串例子
        String xmlString = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<root>\n" +
                "<head>\n" +
                "<code>1</code>\n" +
                "<message>数据下载成功！</message>\n" +
                "<rownum>23</rownum>\n" +
                "</head>\n" +
                "<body>\n" +
                "<violation id=\"0\">\n" +
                "  <dsr>刘鸿彪</dsr>\n" +
                "  <wfdz>大凤路古城段</wfdz>\n" +
                "  <wfsj>2016-07-08 08:48:09</wfsj>\n" +
                "  <hphm>云L298AR</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7050</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314681</wfbh>\n" +
                "  <jszh>532929197703181717</jszh>\n" +
                "  <jtfs>K31</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031468</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"1\">\n" +
                "  <dsr>何天华</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:21:20</wfsj>\n" +
                "  <hphm>云L56331</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314691</wfbh>\n" +
                "  <jszh>532932198807051514</jszh>\n" +
                "  <jtfs>H17</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031469</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"2\">\n" +
                "  <dsr>杨治国</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:26:05</wfsj>\n" +
                "  <hphm>云LN8320</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1340A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314701</wfbh>\n" +
                "  <jszh>532901197812251634</jszh>\n" +
                "  <jtfs>M21</jtfs>\n" +
                "  <hpzl>07</hpzl>\n" +
                "  <jdsbh>532901191031470</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"3\">\n" +
                "  <dsr>李永青</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:28:55</wfsj>\n" +
                "  <hphm>云LN4247</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1207A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314711</wfbh>\n" +
                "  <jszh>532901198201221633</jszh>\n" +
                "  <jtfs>M21</jtfs>\n" +
                "  <hpzl>07</hpzl>\n" +
                "  <jdsbh>532901191031471</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"4\">\n" +
                "  <dsr>王峰</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:31:40</wfsj>\n" +
                "  <hphm>云LY1520</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7050</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314721</wfbh>\n" +
                "  <jszh>532901197512081477</jszh>\n" +
                "  <jtfs>H31</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031472</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"5\">\n" +
                "  <dsr>杨灿兴</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:35:28</wfsj>\n" +
                "  <hphm>云L57217</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314731</wfbh>\n" +
                "  <jszh>532932198207121312</jszh>\n" +
                "  <jtfs>H17</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031473</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"6\">\n" +
                "  <dsr>魏洲</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:41:46</wfsj>\n" +
                "  <hphm>云LFE385</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1225</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314741</wfbh>\n" +
                "  <jszh>511322198804297711</jszh>\n" +
                "  <jtfs>M21</jtfs>\n" +
                "  <hpzl>07</hpzl>\n" +
                "  <jdsbh>532901191031474</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"7\">\n" +
                "  <dsr>段雄宝</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:44:43</wfsj>\n" +
                "  <hphm>云L31455</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314751</wfbh>\n" +
                "  <jszh>532901197710011234</jszh>\n" +
                "  <jtfs>H27</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031475</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"8\">\n" +
                "  <dsr>胡正锋</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:48:26</wfsj>\n" +
                "  <hphm>云L33510</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314761</wfbh>\n" +
                "  <jszh>532930197910271315</jszh>\n" +
                "  <jtfs>Q11</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031476</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"9\">\n" +
                "  <dsr>董培</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:51:31</wfsj>\n" +
                "  <hphm>云L54407</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>6045</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314771</wfbh>\n" +
                "  <jszh>532901198311151410</jszh>\n" +
                "  <jtfs>Z51</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031477</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"10\">\n" +
                "  <dsr>赵建明</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:57:12</wfsj>\n" +
                "  <hphm>云L33338</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314781</wfbh>\n" +
                "  <jszh>53290119741017201X</jszh>\n" +
                "  <jtfs>H27</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031478</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"11\">\n" +
                "  <dsr>胡安红</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 09:59:25</wfsj>\n" +
                "  <hphm>云AB9966</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314791</wfbh>\n" +
                "  <jszh>530326199011031510</jszh>\n" +
                "  <jtfs>H14</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031479</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"12\">\n" +
                "  <dsr>张亚松</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:02:31</wfsj>\n" +
                "  <hphm>云LTG896</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1225</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>53290120<161>11910314801</wfbh>\n" +
                "  <jszh>532901199201281817</jszh>\n" +
                "  <jtfs>K39</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031480</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"13\">\n" +
                "  <dsr>此里尼玛</dsr>\n" +
                "  <wfdz>宁凤线291公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:05:16</wfsj>\n" +
                "  <hphm>云R15866</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1083A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314811</wfbh>\n" +
                "  <jszh>53342219870907131X</jszh>\n" +
                "  <jtfs>H19</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031481</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"14\">\n" +
                "  <dsr>伍胜富</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:13:53</wfsj>\n" +
                "  <hphm>云LGT325</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314821</wfbh>\n" +
                "  <jszh>510103196303160012</jszh>\n" +
                "  <jtfs>K32</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031482</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"15\">\n" +
                "  <dsr>赵永忠</dsr>\n" +
                "  <wfdz>宁凤线<>294公里347米</wfdz>\n" +
                "  <wfsj>2016<-07-08 10:17:55></wfsj>\n" +
                "  <hphm>云LBC274</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1340A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314831</wfbh>\n" +
                "  <jszh>532901196410031618</jszh>\n" +
                "  <jtfs>M21</jtfs>\n" +
                "  <hpzl>07</hpzl>\n" +
                "  <jdsbh>532901191031483</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"16\">\n" +
                "  <dsr>谢天永</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:23:19</wfsj>\n" +
                "  <hphm>云H25809</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910314841</wfbh>\n" +
                "  <jszh>532233198309083853</jszh>\n" +
                "  <jtfs>H14</jtfs>\n" +
                "  <hpzl>01</hpzl>\n" +
                "  <jdsbh>532901191031484</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"17\">\n" +
                "  <dsr>张红芬</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:26:16</wfsj>\n" +
                "  <hphm>云L230DG</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1083A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910315051</wfbh>\n" +
                "  <jszh>532901197406081449</jszh>\n" +
                "  <jtfs>H37</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031505</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"18\">\n" +
                "  <dsr>吴从伟</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:29:57</wfsj>\n" +
                "  <hphm>云LM9976</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1207A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910315941</wfbh>\n" +
                "  <jszh>532927198207071115</jszh>\n" +
                "  <jtfs>M21</jtfs>\n" +
                "  <hpzl>07</hpzl>\n" +
                "  <jdsbh>532901191031594</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"19\">\n" +
                "  <dsr>昂翁曲批</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:32:32</wfsj>\n" +
                "  <hphm>川V83810</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910315951</wfbh>\n" +
                "  <jszh>513336198905035016</jszh>\n" +
                "  <jtfs>K39</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031595</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"20\">\n" +
                "  <dsr>张益刚</dsr>\n" +
                "  <wfdz>宁凤线294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:35:52</wfsj>\n" +
                "  <hphm>云LR9079</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910316171</wfbh>\n" +
                "  <jszh>532930197611161132</jszh>\n" +
                "  <jtfs>K39</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031617</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"21\">\n" +
                "  <dsr>朱星江</dsr>\n" +
                "  <wfdz>宁凤线\b294公里347米</wfdz>\n" +
                "  <wfsj>2016-07-08 10:44:51</wfsj>\n" +
                "  <hphm>云LSD008</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>7005</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012016111910316181</wfbh>\n" +
                "  <jszh>522130197708152050</jszh>\n" +
                "  <jtfs>K39</jtfs>\n" +
                "  <hpzl>02</hpzl>\n" +
                "  <jdsbh>532901191031618</jdsbh>\n" +
                "</violation>\n" +
                "<violation id=\"22\">\n" +
                "  <dsr>杨敬军</dsr>\n" +
                "  <wfdz>宁凤<线\b294公里3>47米</wfdz>\n" +
                "  <wfsj>201<6-07-08 10:>47:30</wfsj>\n" +
                "  <hphm>云E18220</hphm>\n" +
                "  <jkfs>2</jkfs>\n" +
                "  <wfxw>1083A</wfxw>\n" +
                "  <jdslb>1</jdslb>\n" +
                "  <zqmj>007191</zqmj>\n" +
                "  <wfbh>5329012<016111910>316191</wfbh>\n" +
                "  <jszh>532927197304130936<></jszh>\n" +
                "  <jtfs>Q11&nbsp;</jtfs>\n" +
                "  <hpzl>01<临></hpzl>\n" +
                "  <jdsbh>532901191031619</jdsbh>\n" +
                "</violation>\n" +
                "</body>\n" +
                "</root>";


    }

}
