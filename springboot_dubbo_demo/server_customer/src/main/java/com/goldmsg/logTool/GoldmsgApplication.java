package com.goldmsg.logTool;

import com.goldmsg.logTool.utils.RemoteApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Chen

 */
@EnableScheduling
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAsync
@EnableAspectJAutoProxy
@ImportResource(locations = {"file:./config/dubbo.xml"})
public class GoldmsgApplication {

    /**
     * 应用入口
     *
     * @param args 参数
     * @throws IOException IO异常
     */
    public static void main(String[] args) throws IOException {
        String propertiesPath = args[0];
        Properties properties = RemoteApplicationConfig.loadProperties(propertiesPath);
        SpringApplication app = new SpringApplication(GoldmsgApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }
}
