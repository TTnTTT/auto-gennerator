package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.EvaluateRecord;
import com.cqie.system.mapper.EvaluateRecordMapper;
import com.cqie.system.service.IEvaluateRecordService;

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
public class EvaluateRecordServiceImpl extends ServiceImpl<EvaluateRecordMapper, EvaluateRecord> implements IEvaluateRecordService {

    private final EvaluateRecordMapper evaluateRecordMapper;

    @Override
    public IPage<EvaluateRecord> findEvaluateRecords(QueryRequest request, EvaluateRecord evaluateRecord) {
        LambdaQueryWrapper<EvaluateRecord> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<EvaluateRecord> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<EvaluateRecord> findEvaluateRecords(EvaluateRecord evaluateRecord) {
	    LambdaQueryWrapper<EvaluateRecord> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createEvaluateRecord(EvaluateRecord evaluateRecord) {
        return this.save(evaluateRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateEvaluateRecord(EvaluateRecord evaluateRecord) {
        return this.saveOrUpdate(evaluateRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteEvaluateRecord(EvaluateRecord evaluateRecord) {
        LambdaQueryWrapper<EvaluateRecord> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
