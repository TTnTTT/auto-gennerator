package com.cqie.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色菜单 Entity
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Data
@TableName("role_menu")
public class RoleMenu {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 
     */
    @TableField("menu_id")
    private Integer menuId;

}
