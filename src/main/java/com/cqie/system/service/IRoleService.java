package com.cqie.system.service;

import com.cqie.system.entity.Role;
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
public interface IRoleService extends IService<Role> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param role role
     * @return IPage<Role>
     */
    IPage<Role> findRoles(QueryRequest request, Role role);

    /**
     * 查询（所有）
     *
     * @param role role
     * @return List<Role>
     */
    List<Role> findRoles(Role role);

    /**
     * 新增
     *
     * @param role role
     */
    Boolean createRole(Role role);

    /**
     * 修改
     *
     * @param role role
     */
    Boolean updateRole(Role role);

    /**
     * 删除
     *
     * @param role role
     */
    Boolean deleteRole(Role role);
}
