package com.chen.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 基础返回数据类型
 * Created with IntelliJ IDEA
 * Created by chen
 * DATE : 2020/8/4.
 * TIME : 18:55
 * EMAIL : 1272635875@qq.com
 */
@ApiModel(value = "BaseResults", description = "基础返回数据类型")
public class BaseResults<T> implements Serializable {

    private Integer code;    //返回结果代号

    private String msg; //返回结果提示信息

    private T data; //返回消息体

    @ApiModelProperty(value = "返回结果代号")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @ApiModelProperty(value = "返回结果提示信息")
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @ApiModelProperty(value = "返回消息体")
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{"
                + "\"code\":" + '\"' + code + '\"'
                + ",\"msg\":" + '\"' + msg + '\"'
                + ",\"data\":" + data
                + '}';
    }
}
