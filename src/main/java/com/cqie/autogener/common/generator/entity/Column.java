package com.cqie.autogener.common.generator.entity;

import lombok.Data;

/**
 * @author helit747@gmail.com
 * @date 2020/9/18 上午10:25
 */
@Data
public class Column {
    /**
     * 名称
     */
    private String name;
    /**
     * 是否为主键
     */
    private Boolean isKey;
    /**
     * 类型
     */
    private String type;
    /**
     * 注释
     */
    private String remark;
    /**
     * 属性名称
     */
    private String field;
}
