package com.cqie.system.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 课程表 Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("course")
public class Course {

    /**
     * 
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 
     */
    @TableField("college_id")
    private Integer collegeId;

    /**
     * 课程名
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 课程描述
     */
    @TableField("discribe")
    private String discribe;

    /**
     * 
     */
    @TableField("crt_time")
    private Date crtTime;

    /**
     * 
     */
    @TableField("mod_time")
    private Date modTime;

    /**
     * 学院
     */
    @TableField("college")
    private Integer college;

}
