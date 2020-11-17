package com.cqie.autogener.common.generator;

import com.cqie.autogener.common.properties.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author helit747@gmail.com
 * @date 2020/9/20 上午10:07
 *
 * 项目启动完成开始代码生成,生成后记得注释掉!!!!!
 *
 */
@Component
@Order(value = 1)
public class ApplicationImpl implements ApplicationRunner{
    @Autowired
    Handle handle;

    @Autowired
    private  SysProperties sysProperties;
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("boot启动完成,开始代码生成");
        handle.generateBySchema(sysProperties.getGenerator().getGeneratorPackage());
    }
}
