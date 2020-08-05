package com.goldmsg.logTool.service.impl;

import com.goldmsg.logTool.entity.LogInfo;
import com.goldmsg.logTool.entity.TbLogInfo;
import com.goldmsg.logTool.entity.requst.LogSaveRequest;
import com.goldmsg.logTool.entity.requst.LogSearchRequest;
import com.goldmsg.logTool.entity.response.LogResponse;
import com.goldmsg.logTool.mapper.LogMapper;
import com.goldmsg.logTool.service.LogService;
import com.goldmsg.logTool.utils.DateUtil;
import com.goldmsg.logTool.utils.ResultsGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LogServiceImpl implements LogService {

    @Autowired
    protected ResultsGenerator resultsGenerator;
    private Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    //插入日志信息
    @Override
    public Boolean insertLogInfo(LogSaveRequest request) {
        LogInfo logInfo = new LogInfo();
        logInfo.setInsertTime(new Date());
        logInfo.setLog_beginTime(request.getLog_beginTime());
        logInfo.setLog_endTime(request.getLog_endTime());
        logInfo.setDevice_name(request.getDevice_name());
        logInfo.setDevice_code(request.getDevice_code());
        logInfo.setUser_name(request.getUser_name());
        logInfo.setUser_code(request.getUser_code());
        logInfo.setManufacturer(request.getManufacturer());
        mongoTemplate.save(logInfo);
        return true;
    }

    //获取日志返回结果
    @Override
    public List<LogResponse> getLogResponse(LogSearchRequest request) {
        Criteria criteria = Criteria.where("log_beginTime").gte(request.getBeginTime());
        criteria.and("log_endTime").lte(request.getEndTime());

        //查询条件判断
        String device_code = request.getDevice_code();
        String manufacturer = request.getManufacturer();
        String user_code = request.getUser_code();
        String org_code = request.getOrg_code();
        String log_msg = request.getLog_msg();
        if (device_code != null) {
            criteria.and("device_code").is((device_code));
        }
        if (manufacturer != null) {
            criteria.and("manufacturer").is((manufacturer));
        }
        if (user_code != null) {
            criteria.and("user_code").is((user_code));
        }
        if (org_code != null) {
            criteria.and("org_code").is((org_code));
        }
        if (log_msg != null) {
            criteria.and("log_msg").is((log_msg));
        }

        Query query = new Query(criteria);
        List<LogInfo> logInfoList = mongoTemplate.find(query, LogInfo.class);

        //处理数据，然后返回响应
        List<LogResponse> logResponseList = new ArrayList<>();
        for (int i = 0; i < logInfoList.size(); i++) {
            LogResponse response = new LogResponse();
            response.setLog_msg(logInfoList.get(i).getLog_msg());
            response.setDevice_name(logInfoList.get(i).getDevice_name());
            response.setDevice_orgName(logInfoList.get(i).getOrg_name());
            response.setManufacturer(logInfoList.get(i).getManufacturer());
            response.setUser_name(logInfoList.get(i).getUser_name());
            response.setUser_code(logInfoList.get(i).getUser_code());
            response.setLog_beginTime(logInfoList.get(i).getLog_beginTime());
            response.setLog_endTime(logInfoList.get(i).getLog_endTime());
            //...
            logResponseList.add(response);
        }

        return logResponseList;
    }

    /**
     * @return
     */
    @Override
    public String testDubboMethod() {
        StringBuffer a = new StringBuffer("this is a dubbo test!");
        System.out.println("服务提供方被调用：" + a.toString());
        return a.toString();
    }

    @Override
    public List<TbLogInfo> getLogInfos(Map param) {
//        param.put("start", start);
//        param.put("limit", start + limit);
        param.put("startTime","2020-08-03 00:00:00");
        param.put("endTime", "2020-08-03 23:59:59");
        List<TbLogInfo> logInfos = logMapper.getInfos(param);
        if(logInfos!=null){
            System.out.println("debugger");
            return logInfos;
        }else{
            return null;
        }
    }
}
