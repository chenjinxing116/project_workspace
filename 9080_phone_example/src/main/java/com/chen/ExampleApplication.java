package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

/**
 * @author Chen
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExampleApplication {

    /**
     * 应用入口
     *
     * @param args 参数
     * @throws IOException IO异常
     */
    public static void main(String[] args) throws IOException {
        SpringApplication app = new SpringApplication(ExampleApplication.class);
        app.run(args);
    }
}
