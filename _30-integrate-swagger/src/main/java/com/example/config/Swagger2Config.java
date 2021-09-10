package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
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
public class Swagger2Config {

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                //根据基包路径选择接口
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("悟空非空也", "http://www.huaguoshan.tech", "1390128154@qq.com");
        return new ApiInfo(
                "悟空的项目api文档", // 标题
                "实现对用户模块的增删改查", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("test", "dev");

        // 通过 enable() 接收此参数判断是否要显示
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("wukong")
                .enable(flag) //是否启用 Swagger ，false 为浏览器无法访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                // 通过请求路径再过滤
                .paths(PathSelectors.ant("/example/**"))
                .build();
    }

    private ApiInfo apiInfo2() {
        Contact contact = new Contact("悟空非空也", "http://www.huaguoshan.tech", "1390128154@qq.com");
        return new ApiInfo(
                "zbj的项目api文档", // 标题
                "实现对用户模块的增删改查", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    @Bean
    public Docket docket2(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("test", "dev");

        // 通过 enable() 接收此参数判断是否要显示
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo2())
                .groupName("zbj")
                .enable(flag) //是否启用 Swagger ，false 为浏览器无法访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                // 通过请求路径再过滤
                .paths(PathSelectors.ant("/example/**"))
                .build();
    }

}
