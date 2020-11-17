package com.cqie.system.entity;


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
@TableName("evaluate_record")
public class EvaluateRecord {

    /**
     * 评价记录主键
     */
    @TableId(value = "e_r_id", type = IdType.AUTO)
    private Long eRId;

    /**
     * 老师互评得分
     */
    @TableField("eachother_score")
    private Double eachotherScore;

    /**
     * 被评人id
     */
    @TableField("tid")
    private Long tid;

    /**
     * 被评课程id
     */
    @TableField("course_id")
    private Integer courseId;

    /**
     * 给分
     */
    @TableField("total_score")
    private Double totalScore;

    /**
     * 学生评价得分
     */
    @TableField("stu_score")
    private Double stuScore;

}
