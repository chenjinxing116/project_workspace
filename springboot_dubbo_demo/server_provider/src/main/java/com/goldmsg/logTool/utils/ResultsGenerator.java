package com.goldmsg.logTool.utils;

import org.springframework.stereotype.Component;

/**
 * 基础结果集生成工具类
 * Created with IntelliJ IDEA
 * Created by HEQI
 * DATE : 2017/8/10.
 * TIME : 10:12
 * EMAIL : qhs_dream@163.com
 */
@Component
public class ResultsGenerator {

    /**
     *通过指定的key构造返回结果
     * @param key   错误码key
     * @param t     实体
     * @param <T>   返回结果内容
     * @return
     */
    public <T> BaseResults<T> genResults(String key, T t) {
        BaseResults<T> results = new BaseResults<T>();

        results.setCode(ReturnInfoMsg.getRetCode(key));
        results.setMsg(ReturnInfoMsg.getMsg(key));
        results.setData(t);

        return results;
    }

    /**
     * 通过指定的key构造返回结果，自定义显示的消息
     * @param <T>   泛型
     * @return
     */
    public <T> BaseResults<T> genCustomResults(String key, String msg) {
        return genResults(key, null, msg);
    }

    /**
     * 通过指定的key构造返回结果，自定义显示的消息
     * @param key   错误码key
     * @param <T>   返回结果内容
     * @param msg   自定义的消息提示
     * @param t     实体
     * @return
     */
    public <T> BaseResults<T> genResults(String key, T t, String msg) {
        BaseResults<T> results = new BaseResults<T>();

        results.setCode(ReturnInfoMsg.getRetCode(key));
        results.setMsg(msg);
        results.setData(t);

        return results;
    }

    /**
     * 通过指定的key构造返回结果，body为null
     * @param key   错误码key
     * @param <T>   返回结果内容
     * @return
     */
    public <T> BaseResults<T> genResults(String key) {
        return genResults(key, null);
    }

    /**
     * 构建请求成功的结果
     * @param t     成功返回的内容
     * @param <T>   泛型
     * @return
     */
    public <T> BaseResults<T> success(T t) {
        return genResults(ResultsCodeConstants.SUCCESS, t);
    }

    /**
     * 构建请求未知失败的结果
     * @param <T>   泛型
     * @return
     */
    public <T> BaseResults<T> error() {
        return genResults(ResultsCodeConstants.ERROR, null);
    }

    /**
     * 构建请求位置失败的结果，带错误原因
     * @param t   错误原因
     * @param <T>   泛型
     * @return
     */
    public <T> BaseResults<T> error(T t) {
        return genResults(ResultsCodeConstants.ERROR, t);
    }

    /**
     * 通过指定的key，和args参数构造返回结果，body为null
     * @param key   错误码key
     * @param args   提示信息中的参数值
     * @param <T>   泛型
     * @return
     */
    public <T> BaseResults<T> genResultsInfo(String key, Object... args) {
        BaseResults<T> results = new BaseResults<T>();
        results.setCode(ReturnInfoMsg.getRetCode(key));
        String msg = ReturnInfoMsg.getMsg(key);
        String returnMsg = String.format(msg, args);
        results.setMsg(returnMsg);
        results.setData(null);
        return results;
    }

}
