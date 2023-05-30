package com.boot.teach.common.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger config 配置类
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("高校教学系统teach-system接口文档").description("接口文档")
                .contact(new Contact("有任何问题可以联系此邮箱","","1670373895@qq.com"))
                .version("V1.0")
                .build();
    }

    @Bean
    public Docket baseApiInfo(){
        return  new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boot.teach.**.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}
