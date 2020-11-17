package com.cqie.system.service;

import com.cqie.system.entity.RoleMenu;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色菜单 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface IRoleMenuService extends IService<RoleMenu> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param roleMenu roleMenu
     * @return IPage<RoleMenu>
     */
    IPage<RoleMenu> findRoleMenus(QueryRequest request, RoleMenu roleMenu);

    /**
     * 查询（所有）
     *
     * @param roleMenu roleMenu
     * @return List<RoleMenu>
     */
    List<RoleMenu> findRoleMenus(RoleMenu roleMenu);

    /**
     * 新增
     *
     * @param roleMenu roleMenu
     */
    Boolean createRoleMenu(RoleMenu roleMenu);

    /**
     * 修改
     *
     * @param roleMenu roleMenu
     */
    Boolean updateRoleMenu(RoleMenu roleMenu);

    /**
     * 删除
     *
     * @param roleMenu roleMenu
     */
    Boolean deleteRoleMenu(RoleMenu roleMenu);
}
