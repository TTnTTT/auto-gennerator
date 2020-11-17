package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.RoleMenu;
import com.cqie.system.mapper.RoleMenuMapper;
import com.cqie.system.service.IRoleMenuService;

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
 * 角色菜单 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    private final RoleMenuMapper roleMenuMapper;

    @Override
    public IPage<RoleMenu> findRoleMenus(QueryRequest request, RoleMenu roleMenu) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<RoleMenu> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<RoleMenu> findRoleMenus(RoleMenu roleMenu) {
	    LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createRoleMenu(RoleMenu roleMenu) {
        return this.save(roleMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateRoleMenu(RoleMenu roleMenu) {
        return this.saveOrUpdate(roleMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteRoleMenu(RoleMenu roleMenu) {
        LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
