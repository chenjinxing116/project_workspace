package com.goldmsg.logTool.utils;


/**
 * 返回信息内容定义实体
 * Created with IntelliJ IDEA
 * Created by HEQI
 * DATE : 2017/8/10.
 * TIME : 16:53
 * EMAIL : qhs_dream@163.com
 */
public class ReturnCode {
    private String msg; //返回的信息
    private Integer retCode;    //返回码

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }
}
