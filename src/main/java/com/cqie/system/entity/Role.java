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
@TableName("role")
public class Role {

    /**
     * 
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 
     */
    @TableField("discrption")
    private String discrption;

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

}
