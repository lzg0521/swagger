package com.li.swagger.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket userDocket() {
        ApiInfo apiInfo=new ApiInfoBuilder()
                .title("用户账号中心")//标题
                .description("集成swagger2构建RESTFul风格接口")//描述
                .termsOfServiceUrl("http://wwww.baidu.com") //服务条框
                .contact(new Contact("LZG","http://www.baidu.com","1900000000"))//联系方式
                .license("采用Apache2.0许可证")
                .licenseUrl("http://www.baidu.com")//许可证地址
                .version("1.0.0")
                .extensions(Arrays.asList(new StringVendorExtension("LZG","111")))//扩展信息
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("user group")
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }
    @Bean
    public Docket productDocket() {
        ApiInfo apiInfo=new ApiInfoBuilder()
                .title("商品中心")//标题
                .description("集成swagger2构建RESTFul风格接口")//描述
                .termsOfServiceUrl("http://wwww.baidu.com") //服务条框
                .contact(new Contact("LZG","http://www.baidu.com","1900000000"))//联系方式
                .license("采用Apache2.0许可证")
                .licenseUrl("http://www.baidu.com")//许可证地址
                .version("1.0.0")
                .extensions(Arrays.asList(new StringVendorExtension("LZG","111")))//扩展信息
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("product group")
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/product/**"))
                .build();
    }
}
