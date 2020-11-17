package com.cqie.system.service;

import com.cqie.system.entity.Clazz;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 班级 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface IClazzService extends IService<Clazz> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param clazz clazz
     * @return IPage<Clazz>
     */
    IPage<Clazz> findClazzs(QueryRequest request, Clazz clazz);

    /**
     * 查询（所有）
     *
     * @param clazz clazz
     * @return List<Clazz>
     */
    List<Clazz> findClazzs(Clazz clazz);

    /**
     * 新增
     *
     * @param clazz clazz
     */
    Boolean createClazz(Clazz clazz);

    /**
     * 修改
     *
     * @param clazz clazz
     */
    Boolean updateClazz(Clazz clazz);

    /**
     * 删除
     *
     * @param clazz clazz
     */
    Boolean deleteClazz(Clazz clazz);
}
