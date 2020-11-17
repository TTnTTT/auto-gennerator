package com.cqie.system.service;

import com.cqie.system.entity.Options;
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
public interface IOptionsService extends IService<Options> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param options options
     * @return IPage<Options>
     */
    IPage<Options> findOptionss(QueryRequest request, Options options);

    /**
     * 查询（所有）
     *
     * @param options options
     * @return List<Options>
     */
    List<Options> findOptionss(Options options);

    /**
     * 新增
     *
     * @param options options
     */
    Boolean createOptions(Options options);

    /**
     * 修改
     *
     * @param options options
     */
    Boolean updateOptions(Options options);

    /**
     * 删除
     *
     * @param options options
     */
    Boolean deleteOptions(Options options);
}
