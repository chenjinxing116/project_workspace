package com.goldmsg.logTool.utils;


import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;


/**
 * Created with IntelliJ IDEA.
 * User: KINKOO
 * Date: 14-4-3
 * Time: 下午3:07
 */
public class OverallVariable {

    public static String SYN_BEGIN_DATE = "2014-04-16 00:00:00";
    private static final Logger LOG = LoggerFactory.getLogger(OverallVariable.class);

    public static String connectWebService(String urlname, Object[] objects, String operate, int timeout)
            throws RemoteException
    {
        Service service = new Service();
        String retValue = "";
        try
        {
            Call call = (Call)service.createCall();
            call.setTimeout(Integer.valueOf(60000 * timeout));
            call.setOperation(operate);
            call.setTargetEndpointAddress(urlname);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(urlname.substring(0, urlname.length() - 5));
            retValue = (String)call.invoke(objects);
            LOG.debug(retValue);
        }
        catch (ServiceException e)
        {
            LOG.error("OverallVariable::ServiceException\n" + e.getMessage());
        }
        return retValue;
    }
    /**
     * 连接webservice方法
     *
     * @param urlname wsdl地址
     * @param objects 输入参数
     * @param operate 操作类型，查询/写入
     * @return 返回结果字符串
     */
    public static  String connectWebService(String urlname, Object[] objects, String operate,String namespaceURI) throws RemoteException {
        Service service = new Service();
        String retValue = "";
        try {
            Call call = (Call) service.createCall();
            call.setTimeout(60000 * 3);
            call.setOperation(operate);
            call.setOperationName(new QName(namespaceURI, operate));
            //xtlb jkxlh jkid cjsqbh dwjgdm dwmc yhbz yhxm zdbs UTF8XmlDoc
            call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg1", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg2", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg3", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg4", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg5", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg6", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg7", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg8", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.addParameter("arg9", XMLType.XSD_STRING, ParameterMode.IN);//接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型

       
            call.setTargetEndpointAddress(urlname);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(urlname.substring(0, urlname.length() - 5));
            retValue = (String) call.invoke(objects);
            MessageContext messageContext = call.getMessageContext();
            Message reqMsg = messageContext.getRequestMessage();
            //System.out.println(reqMsg.getSOAPPartAsString());
            LOG.debug("调用的xml信息"+reqMsg.getSOAPPartAsString());
//            LOG.info("调用的urlname"+urlname);
//            LOG.info("调用的方法operate"+operate);

            LOG.debug(retValue);
        } catch (ServiceException e) {
            LOG.error("OverallVariable::ServiceException\n" + e.getMessage());
        }
        return retValue;
    }







}
