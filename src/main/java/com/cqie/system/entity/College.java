package com.cqie.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 学院表 Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("college")
public class College {

    /**
     * 
     */
    @TableId(value = "college_id", type = IdType.AUTO)
    private Integer collegeId;

    /**
     * 
     */
    @TableField("college_name")
    private String collegeName;

}
