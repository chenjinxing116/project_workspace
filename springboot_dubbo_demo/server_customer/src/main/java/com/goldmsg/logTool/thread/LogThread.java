package com.goldmsg.logTool.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by chenjinxing on 2019/8/5.
 */
@Service
public class LogThread {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Scheduled(fixedDelay = 2 * 60 * 1000)
    public void pullLOG(){
//        System.out.println("定时获取日志");
//        LogInfo logInfo = new LogInfo();
//        logInfo.setInsertTime(new Date());
//        logInfo.setLog_msg("测试查询接口内容");
//        logInfo.setManufacturer("国迈科技");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date =null;
//        try {
//            date = sdf.parse("2019-08-01 00:00:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        logInfo.setLog_beginTime(date);
//        logInfo.setLog_endTime(new Date());
//        logInfo.setDevice_code("1");
//        logInfo.setUser_code("110110");
//        logInfo.setUser_name("鱼尾警官");
//        mongoTemplate.save(logInfo);
    }


    @Scheduled(fixedDelay = 1 * 60 * 1000)
    public void cleanLOG(){
//        System.out.println("定时清理日志：目前设计只保存一个月的日志");
//        Criteria criteria = Criteria.where("happenTime").lt(new Date());
//        Query query = new Query(criteria);
//        query.limit(3);
////       List<LogInfo> logInfoList = mongoTemplate.find(query, LogInfo.class);
//        WriteResult writeResult = mongoTemplate.remove(query,LogInfo.class);
//        System.out.println(writeResult.getN());
    }
}
