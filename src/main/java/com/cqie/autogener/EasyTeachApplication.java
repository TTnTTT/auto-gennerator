package com.cqie.autogener;


import com.cqie.autogener.common.properties.SysProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.cqie.autogener.**.mapper")
@EnableConfigurationProperties({SysProperties.class})
public class EasyTeachApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyTeachApplication.class, args);
    }

}
