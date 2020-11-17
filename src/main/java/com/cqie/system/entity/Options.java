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
@TableName("options")
public class Options {

    /**
     * 
     */
    @TableId(value = "option_id", type = IdType.AUTO)
    private Integer optionId;

    /**
     * 题目内容
     */
    @TableField("option_name")
    private String optionName;

    /**
     * 题目分数
     */
    @TableField("option_score")
    private Double optionScore;

    /**
     * 所属指标
     */
    @TableField("quota")
    private Integer quota;

}
