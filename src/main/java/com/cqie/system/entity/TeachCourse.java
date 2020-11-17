package com.cqie.system.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 老师授课 Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("teach_course")
public class TeachCourse {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField("course_id")
    private Integer courseId;

    /**
     * 
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 
     */
    @TableField("class_time")
    private Date classTime;

}
