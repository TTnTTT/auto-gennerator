package com.cqie.autogener.common.generator.helper;



import com.alibaba.fastjson.JSONObject;
import com.cqie.autogener.common.generator.entity.Column;
import com.cqie.autogener.common.generator.entity.FieldType;
import com.cqie.autogener.common.generator.entity.GeneratorConfig;
import cc.mrbird.febs.generator.entity.GeneratorConstant;
import com.cqie.autogener.common.utils.StringUtil;
import com.google.common.io.Files;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author MrBird
 */
@Slf4j
@Component
public class GeneratorHelper {

    public void generateEntityFile(List<Column> columns, GeneratorConfig configure) throws Exception {
        String suffix = GeneratorConstant.JAVA_FILE_SUFFIX;// .java
        String path = getFilePath(configure, configure.getEntityPackage(), suffix, false);
        String templateName = GeneratorConstant.ENTITY_TEMPLATE;
        File entityFile = new File(path);
        JSONObject data = toJsonObject(configure);
        data.put("hasDate", false);
        data.put("hasBigDecimal", false);
        columns.forEach(c -> {
            c.setField(StringUtil.underscoreToCamel(StringUtils.lowerCase(c.getName())));
            if (StringUtils.containsAny(c.getType(), FieldType.DATE, FieldType.DATETIME, FieldType.TIMESTAMP)) {
                data.put("hasDate", true);//遇到这三种类型都转换为Date
            }
            if (StringUtils.containsAny(c.getType(), FieldType.DECIMAL, FieldType.NUMERIC)) {
                data.put("hasBigDecimal", true);
            }
        });
        data.put("columns", columns);
        this.generateFileByTemplate(templateName, entityFile, data);//调用
    }

    public void generateMapperFile(List<Column> columns, GeneratorConfig configure) throws Exception {
        String suffix = GeneratorConstant.MAPPER_FILE_SUFFIX;
        String path = getFilePath(configure, configure.getMapperPackage(), suffix, false);
        String templateName = GeneratorConstant.MAPPER_TEMPLATE;
        File mapperFile = new File(path);
        generateFileByTemplate(templateName, mapperFile, toJsonObject(configure));
    }

    public void generateServiceFile(List<Column> columns, GeneratorConfig configure) throws Exception {
        String suffix = GeneratorConstant.SERVICE_FILE_SUFFIX;
        String path = getFilePath(configure, configure.getServicePackage(), suffix, true);
        String templateName = GeneratorConstant.SERVICE_TEMPLATE;
        File serviceFile = new File(path);
        generateFileByTemplate(templateName, serviceFile, toJsonObject(configure));
    }

    public void generateServiceImplFile(List<Column> columns, GeneratorConfig configure) throws Exception {
        String suffix = GeneratorConstant.SERVICEIMPL_FILE_SUFFIX;
        String path = getFilePath(configure, configure.getServiceImplPackage(), suffix, false);
        String templateName = GeneratorConstant.SERVICEIMPL_TEMPLATE;
        File serviceImplFile = new File(path);
        generateFileByTemplate(templateName, serviceImplFile, toJsonObject(configure));
    }

    public void generateControllerFile(List<Column> columns, GeneratorConfig configure) throws Exception {
        String suffix = GeneratorConstant.CONTROLLER_FILE_SUFFIX;
        String path = getFilePath(configure, configure.getControllerPackage(), suffix, false);
        String templateName = GeneratorConstant.CONTROLLER_TEMPLATE;
        log.warn("Controller文件地址："+path);
        File controllerFile = new File(path);
        generateFileByTemplate(templateName, controllerFile, toJsonObject(configure));
    }

    public void generateMapperXmlFile(List<Column> columns, GeneratorConfig configure) throws Exception {
        String suffix = GeneratorConstant.MAPPERXML_FILE_SUFFIX;
        String path = getFilePath(configure, configure.getMapperXmlPackage(), suffix, false);
        String templateName = GeneratorConstant.MAPPERXML_TEMPLATE;
        File mapperXmlFile = new File(path);
        JSONObject data = toJsonObject(configure);
        columns.forEach(c -> c.setField(StringUtil.underscoreToCamel(StringUtils.lowerCase(c.getName()))));
        data.put("columns", columns);
        generateFileByTemplate(templateName, mapperXmlFile, data);
    }

    /**
     * 根据模板(templateName)把数据对象(data)中的数据写入目标文件(file)
     * @param templateName
     * @param file
     * @param data
     * @throws Exception
     */
    @SuppressWarnings("UnstableApiUsage")
    private void generateFileByTemplate(String templateName, File file, Object data) throws Exception {
        Template template = getTemplate(templateName);
        Files.createParentDirs(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try (Writer out = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8), 10240)) {
            //根据模板数据写入
            template.process(data, out);
        } catch (Exception e) {
            String message = "代码生成异常";
            log.error(message, e);
            throw new Exception(message);
        }
    }
    private Template getTemplate(String templateName) throws Exception {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_20);
        String templatePath = this.getClass().getResource("/generator/templates/").getPath();//获取模版引擎地址


        configuration.setDirectoryForTemplateLoading(new File(templatePath));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return configuration.getTemplate(templateName);

    }
    private static String getFilePath(GeneratorConfig configure, String packagePath, String suffix, boolean serviceInterface) {
        String filePath = configure.getJavaPath() +///src/main/java/ java文件路径，固定值
                packageConvertPath(configure.getBasePackage() + "." + packagePath);//com.cqie.easyteach.entity
        log.warn("基础包："+filePath);
       if (serviceInterface) {
            filePath += "I";
        }
       if (GeneratorConstant.MAPPERXML_FILE_SUFFIX.equals(suffix)){//后缀是mapper.xml时
           filePath = configure.getResourcesPath() + packageConvertPath(packagePath+"/system");
       }
        filePath += configure.getClassName() + suffix;
        return filePath;
    }
//两边加上'/'
    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
//转为JSONObject类型
    private JSONObject toJsonObject(Object o) {
        return JSONObject.parseObject(JSONObject.toJSON(o).toString());
    }


}
