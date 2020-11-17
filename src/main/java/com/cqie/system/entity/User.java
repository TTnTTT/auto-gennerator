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
@TableName("user")
public class User {

    /**
     * 
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 
     */
    @TableField("clazz_id")
    private Integer clazzId;

    /**
     * 
     */
    @TableField("real_name")
    private String realName;

    /**
     * (学)工号
     */
    @TableField("no")
    private String no;

    /**
     * 
     */
    @TableField("password")
    private String password;

    /**
     * 
     */
    @TableField("email")
    private String email;

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
     * 
     */
    @TableField("status")
    private Integer status;

    /**
     * 
     */
    @TableField("login_time")
    private Date loginTime;

}
