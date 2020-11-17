package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.Clazz;
import com.cqie.system.mapper.ClazzMapper;
import com.cqie.system.service.IClazzService;

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
 * 班级 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements IClazzService {

    private final ClazzMapper clazzMapper;

    @Override
    public IPage<Clazz> findClazzs(QueryRequest request, Clazz clazz) {
        LambdaQueryWrapper<Clazz> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Clazz> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Clazz> findClazzs(Clazz clazz) {
	    LambdaQueryWrapper<Clazz> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createClazz(Clazz clazz) {
        return this.save(clazz);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateClazz(Clazz clazz) {
        return this.saveOrUpdate(clazz);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteClazz(Clazz clazz) {
        LambdaQueryWrapper<Clazz> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
