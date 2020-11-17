package com.cqie.autogener.common.properties;

import com.cqie.autogener.common.generator.entity.GeneratorConfig;
import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author helit747@gmail.com
 * @date 2020/9/18 下午4:37
 */
@SpringBootConfiguration
@PropertySource(value = {"classpath:system.properties"})// 注意,只能从.properts文件取值,yml不行
@ConfigurationProperties(prefix = "sys") //从全局配置文件取值
@Data
public class SysProperties {
    private Integer aa;
    private GeneratorConfig generator;
}
