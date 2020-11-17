package com.cqie.system.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 评教课程、评教辅导员 Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("course_evaluate")
public class CourseEvaluate {

    /**
     * 
     */
    @TableId(value = "c_e_id", type = IdType.AUTO)
    private Long cEId;

    /**
     * 
     */
    @TableField("course_id")
    private Integer courseId;

    /**
     * 评教学生
            
     */
    @TableField("student_id")
    private Long studentId;

    /**
     * 评教分数
     */
    @TableField("score")
    private Integer score;

    /**
     * 评教内容
     */
    @TableField("content")
    private String content;

    /**
     * 被评老师
     */
    @TableField("teach")
    private Long teach;

    /**
     * 
     */
    @TableField("crt_time")
    private Date crtTime;

}
