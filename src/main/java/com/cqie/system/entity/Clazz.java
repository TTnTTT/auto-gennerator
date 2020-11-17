package com.cqie.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 班级 Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("clazz")
public class Clazz {

    /**
     * 
     */
    @TableId(value = "clazz_id", type = IdType.AUTO)
    private Integer clazzId;

    /**
     * 
     */
    @TableField("college_id")
    private Integer collegeId;

    /**
     * 班级编号
     */
    @TableField("clazz_no")
    private String clazzNo;

    /**
     * 辅导员
     */
    @TableField("instructor")
    private Long instructor;

}
