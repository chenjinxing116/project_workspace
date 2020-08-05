package com.goldmsg.logTool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;


/**
 * Created with IntelliJ IDEA
 * Created by zhaohuan
 * DATE : 2017/8/22.
 * TIME : 16:09
 * EMAIL : 791934554@qq.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Swagger配置
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)                  //文档类型
            .genericModelSubstitutes(Collection.class)              //返回值为Collection<T>时,将其“类型化”
            .genericModelSubstitutes(ResponseEntity.class)
            .apiInfo(apiInfo())                                     //文档信息
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.goldmsg"))    //注解扫描路径
            .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
            .title("RESTful API手册")
            .description("<strong>可选字段标记有optional，其他为必填字段。</strong>")
            .contact("平台研发部")
            .version("1.0")
            .build();
    }

}
