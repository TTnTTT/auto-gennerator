package com.cqie.autogener.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author helit747@gmail.com
 * @date 2020/9/20 上午9:37
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cqie.system"))//controller必须放在这里规定的包或子包下
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().title("代码自动生成")
                        .description("一键生成代码的完整解决方案")
                        .version("1.0")
                        .contact(new Contact("嘿嘿","blog.csdn.net","helit747@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }
}
