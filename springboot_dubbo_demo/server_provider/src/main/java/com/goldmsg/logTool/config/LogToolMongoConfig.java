//package com.goldmsg.logTool.config;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 视音频的数据层配置
// * Created with IntelliJ IDEA
// * Created by HEQI
// * DATE : 2018/1/11.
// * TIME : 11:25
// * EMAIL : qhs_dream@163.com
// */
//@Configuration
//@EnableMongoRepositories(basePackages = "com.goldmsg.logTool",
//    mongoTemplateRef = LogToolMongoConfig.AUDIO_TEMPLATE_NAME)
//public class LogToolMongoConfig {
//
//    public static final String AUDIO_TEMPLATE_NAME    = "logTemplate";
//
//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.data.mongodb.audio")
//    public MongoProperties audioMongoProperties() {
//        return new MongoProperties();
//    }
//
//
//
//    @Primary
//    @Bean(name = AUDIO_TEMPLATE_NAME)
//    public MongoTemplate audioMongoTemplate() throws Exception {
//        return new MongoTemplate(audioFactory(audioMongoProperties()));
//    }
//
//
//    /**
//     * 实例化SimpleMongoDbFactory
//     *
//     * @param mongo mongo属性
//     * @return MongoDbFactory 工厂
//     * @throws Exception 异常
//     */
//    @Bean
//    @Primary
//    public MongoDbFactory audioFactory(MongoProperties mongo) throws Exception {
//        ServerAddress serverAddress = new ServerAddress(mongo.getHost(), mongo.getPort());
//        List<MongoCredential> mongoCredentialList = new ArrayList<>();
//
//        String userName = mongo.getUsername();
//        char []pass = mongo.getPassword();
//
//        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(new String(pass))) {
//            mongoCredentialList.add(
//                    MongoCredential.createCredential(
//                            userName,
//                            mongo.getDatabase(),
//                            pass
//                    )
//            );
//        }
//        return new SimpleMongoDbFactory(new MongoClient(serverAddress, mongoCredentialList), mongo.getDatabase());
//    }
//
//}
