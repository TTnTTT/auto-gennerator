package com.cqie.system.service;

import com.cqie.system.entity.EvaluateRecord;
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
public interface IEvaluateRecordService extends IService<EvaluateRecord> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param evaluateRecord evaluateRecord
     * @return IPage<EvaluateRecord>
     */
    IPage<EvaluateRecord> findEvaluateRecords(QueryRequest request, EvaluateRecord evaluateRecord);

    /**
     * 查询（所有）
     *
     * @param evaluateRecord evaluateRecord
     * @return List<EvaluateRecord>
     */
    List<EvaluateRecord> findEvaluateRecords(EvaluateRecord evaluateRecord);

    /**
     * 新增
     *
     * @param evaluateRecord evaluateRecord
     */
    Boolean createEvaluateRecord(EvaluateRecord evaluateRecord);

    /**
     * 修改
     *
     * @param evaluateRecord evaluateRecord
     */
    Boolean updateEvaluateRecord(EvaluateRecord evaluateRecord);

    /**
     * 删除
     *
     * @param evaluateRecord evaluateRecord
     */
    Boolean deleteEvaluateRecord(EvaluateRecord evaluateRecord);
}
