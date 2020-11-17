package com.cqie.system.service;

import com.cqie.system.entity.UserRole;
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
public interface IUserRoleService extends IService<UserRole> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userRole userRole
     * @return IPage<UserRole>
     */
    IPage<UserRole> findUserRoles(QueryRequest request, UserRole userRole);

    /**
     * 查询（所有）
     *
     * @param userRole userRole
     * @return List<UserRole>
     */
    List<UserRole> findUserRoles(UserRole userRole);

    /**
     * 新增
     *
     * @param userRole userRole
     */
    Boolean createUserRole(UserRole userRole);

    /**
     * 修改
     *
     * @param userRole userRole
     */
    Boolean updateUserRole(UserRole userRole);

    /**
     * 删除
     *
     * @param userRole userRole
     */
    Boolean deleteUserRole(UserRole userRole);
}
