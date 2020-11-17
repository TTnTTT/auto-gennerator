package com.cqie.system.service;

import com.cqie.system.entity.Menu;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param menu menu
     * @return IPage<Menu>
     */
    IPage<Menu> findMenus(QueryRequest request, Menu menu);

    /**
     * 查询（所有）
     *
     * @param menu menu
     * @return List<Menu>
     */
    List<Menu> findMenus(Menu menu);

    /**
     * 新增
     *
     * @param menu menu
     */
    Boolean createMenu(Menu menu);

    /**
     * 修改
     *
     * @param menu menu
     */
    Boolean updateMenu(Menu menu);

    /**
     * 删除
     *
     * @param menu menu
     */
    Boolean deleteMenu(Menu menu);
}
