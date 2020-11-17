package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.UserRole;
import com.cqie.system.mapper.UserRoleMapper;
import com.cqie.system.service.IUserRoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Override
    public IPage<UserRole> findUserRoles(QueryRequest request, UserRole userRole) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserRole> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserRole> findUserRoles(UserRole userRole) {
	    LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createUserRole(UserRole userRole) {
        return this.save(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateUserRole(UserRole userRole) {
        return this.saveOrUpdate(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteUserRole(UserRole userRole) {
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
