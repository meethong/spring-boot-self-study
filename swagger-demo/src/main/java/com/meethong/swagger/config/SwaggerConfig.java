package com.meethong.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //配置Swagger的Docket的实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger环境
        Profiles profiles=Profiles.of("dev","test");

        //获取项目的环境
       boolean flag=environment.acceptsProfiles(profiles);
       //通过environment.acceptsProfiles判断是否是处于自己设定的环境当中
        System.out.println(flag);
        return new Docket(DocumentationType.SWAGGER_2)
                      .groupName("廖洪")
                      .apiInfo(apiInfo())
                      .enable(flag) //eable 是否启动Swagger 如果为false,则Swagger不能再浏览器访问
                      .select()
                      //RequestHandlerSelectors,配置要扫描接口的方式
                      //basePackage 指定扫描的包
                      //any()扫描全部
                      //withClassAnnotatio 扫描类上的注解
                      //withMethodAnnotation 扫描方法上的注解
                      .apis(RequestHandlerSelectors.basePackage("com.meethong.swagger.controller"))
                      //.paths(PathSelectors.ant("/hello/***"))
                      .build();
    }
    private ApiInfo apiInfo(){
        Contact  contact= new Contact("liaoh", "https://blog.opsta.cn", "me@opsta.cn");
        return  new ApiInfo("Swagger文档",
                      "测试",
                      "1.0",
                      "https://blog.opsta.cn",
                      contact,
                      "Apache 2.0",
                      "http://www.apache.org/licenses/LICENSE-2.0",
                      new ArrayList());
    }
}
