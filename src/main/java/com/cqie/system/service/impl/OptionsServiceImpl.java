package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.Options;
import com.cqie.system.mapper.OptionsMapper;
import com.cqie.system.service.IOptionsService;

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
public class OptionsServiceImpl extends ServiceImpl<OptionsMapper, Options> implements IOptionsService {

    private final OptionsMapper optionsMapper;

    @Override
    public IPage<Options> findOptionss(QueryRequest request, Options options) {
        LambdaQueryWrapper<Options> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Options> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Options> findOptionss(Options options) {
	    LambdaQueryWrapper<Options> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createOptions(Options options) {
        return this.save(options);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateOptions(Options options) {
        return this.saveOrUpdate(options);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteOptions(Options options) {
        LambdaQueryWrapper<Options> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
