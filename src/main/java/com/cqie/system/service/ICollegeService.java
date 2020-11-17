package com.cqie.system.service;

import com.cqie.system.entity.College;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 学院表 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface ICollegeService extends IService<College> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param college college
     * @return IPage<College>
     */
    IPage<College> findColleges(QueryRequest request, College college);

    /**
     * 查询（所有）
     *
     * @param college college
     * @return List<College>
     */
    List<College> findColleges(College college);

    /**
     * 新增
     *
     * @param college college
     */
    Boolean createCollege(College college);

    /**
     * 修改
     *
     * @param college college
     */
    Boolean updateCollege(College college);

    /**
     * 删除
     *
     * @param college college
     */
    Boolean deleteCollege(College college);
}
