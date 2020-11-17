package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.EvaluateRecords;
import com.cqie.system.mapper.EvaluateRecordsMapper;
import com.cqie.system.service.IEvaluateRecordsService;

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
public class EvaluateRecordsServiceImpl extends ServiceImpl<EvaluateRecordsMapper, EvaluateRecords> implements IEvaluateRecordsService {

    private final EvaluateRecordsMapper evaluateRecordsMapper;

    @Override
    public IPage<EvaluateRecords> findEvaluateRecordss(QueryRequest request, EvaluateRecords evaluateRecords) {
        LambdaQueryWrapper<EvaluateRecords> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<EvaluateRecords> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<EvaluateRecords> findEvaluateRecordss(EvaluateRecords evaluateRecords) {
	    LambdaQueryWrapper<EvaluateRecords> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createEvaluateRecords(EvaluateRecords evaluateRecords) {
        return this.save(evaluateRecords);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateEvaluateRecords(EvaluateRecords evaluateRecords) {
        return this.saveOrUpdate(evaluateRecords);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteEvaluateRecords(EvaluateRecords evaluateRecords) {
        LambdaQueryWrapper<EvaluateRecords> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
