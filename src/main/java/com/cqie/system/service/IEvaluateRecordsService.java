package com.cqie.system.service;

import com.cqie.system.entity.EvaluateRecords;
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
public interface IEvaluateRecordsService extends IService<EvaluateRecords> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param evaluateRecords evaluateRecords
     * @return IPage<EvaluateRecords>
     */
    IPage<EvaluateRecords> findEvaluateRecordss(QueryRequest request, EvaluateRecords evaluateRecords);

    /**
     * 查询（所有）
     *
     * @param evaluateRecords evaluateRecords
     * @return List<EvaluateRecords>
     */
    List<EvaluateRecords> findEvaluateRecordss(EvaluateRecords evaluateRecords);

    /**
     * 新增
     *
     * @param evaluateRecords evaluateRecords
     */
    Boolean createEvaluateRecords(EvaluateRecords evaluateRecords);

    /**
     * 修改
     *
     * @param evaluateRecords evaluateRecords
     */
    Boolean updateEvaluateRecords(EvaluateRecords evaluateRecords);

    /**
     * 删除
     *
     * @param evaluateRecords evaluateRecords
     */
    Boolean deleteEvaluateRecords(EvaluateRecords evaluateRecords);
}
