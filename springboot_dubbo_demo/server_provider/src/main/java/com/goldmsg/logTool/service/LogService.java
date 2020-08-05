package com.goldmsg.logTool.service;

import com.goldmsg.logTool.entity.TbLogInfo;
import com.goldmsg.logTool.entity.requst.LogSaveRequest;
import com.goldmsg.logTool.entity.requst.LogSearchRequest;
import com.goldmsg.logTool.entity.response.LogResponse;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjinxing on 2019/8/5.
 */
@Service
public interface LogService extends Serializable {
    //插入日志信息
    Boolean insertLogInfo(LogSaveRequest request);
    //获取日志返回结果
    List<LogResponse> getLogResponse(LogSearchRequest request);

    String testDubboMethod();

    List<TbLogInfo> getLogInfos(Map param);
}
