package com.cqie.system.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("evaluate_records")
public class EvaluateRecords {

    /**
     * 评价记录主键
     */
    @TableId(value = "e_r_id", type = IdType.AUTO)
    private Long eRId;

    /**
     * 评价者
     */
    @TableField("student")
    private Long student;

    /**
     * 被评价者
     */
    @TableField("teacher")
    private Long teacher;

    /**
     * 评价课程id
     */
    @TableField("course")
    private Integer course;

    /**
     * 评价内容
     */
    @TableField("content")
    private String content;

    /**
     * 给分
     */
    @TableField("score")
    private Double score;

    /**
     * 评价时间
     */
    @TableField("crt_time")
    private Date crtTime;

}
