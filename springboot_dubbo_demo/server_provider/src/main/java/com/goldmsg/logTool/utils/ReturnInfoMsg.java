package com.goldmsg.logTool.utils;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回代码常量类
 * Created with IntelliJ IDEA
 * Created by HEQI
 * DATE : 2017/8/10.
 * TIME : 10:19
 * EMAIL : qhs_dream@163.com
 */
public class ReturnInfoMsg {

    public static Map<String, ReturnCode> returnCode = new HashMap<String, ReturnCode>();

    /**
     * 获取返回信息
     * @param key   codeName
     * @return
     */
    public static String getMsg(String key) {
        ReturnCode entity = returnCode.get(key);

        if (entity != null) {
            return entity.getMsg();
        }

        return "";
    }

    /**
     * 获取返回码
     * @param key   codeName
     * @return
     */
    public static Integer getRetCode(String key) {
        ReturnCode entity = returnCode.get(key);

        if (entity != null) {
            return entity.getRetCode();
        }

        return null;
    }

}
