package com.cqie.system.service;

import com.cqie.system.entity.User;
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
public interface IUserService extends IService<User> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param user user
     * @return IPage<User>
     */
    IPage<User> findUsers(QueryRequest request, User user);

    /**
     * 查询（所有）
     *
     * @param user user
     * @return List<User>
     */
    List<User> findUsers(User user);

    /**
     * 新增
     *
     * @param user user
     */
    Boolean createUser(User user);

    /**
     * 修改
     *
     * @param user user
     */
    Boolean updateUser(User user);

    /**
     * 删除
     *
     * @param user user
     */
    Boolean deleteUser(User user);
}
