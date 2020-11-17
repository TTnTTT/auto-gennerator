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
@TableName("menu")
public class Menu {

    /**
     * 
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 
     */
    @TableField("menu_url")
    private String menuUrl;

    /**
     * 权限
     */
    @TableField("perms")
    private String perms;

    /**
     * 类型（0按钮 1菜单）
     */
    @TableField("type")
    private Integer type;

    /**
     * 
     */
    @TableField("icon")
    private String icon;

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
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;

}
