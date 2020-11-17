package com.cqie.system.service;

import com.cqie.system.entity.CourseEvaluate;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 评教课程、评教辅导员 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface ICourseEvaluateService extends IService<CourseEvaluate> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param courseEvaluate courseEvaluate
     * @return IPage<CourseEvaluate>
     */
    IPage<CourseEvaluate> findCourseEvaluates(QueryRequest request, CourseEvaluate courseEvaluate);

    /**
     * 查询（所有）
     *
     * @param courseEvaluate courseEvaluate
     * @return List<CourseEvaluate>
     */
    List<CourseEvaluate> findCourseEvaluates(CourseEvaluate courseEvaluate);

    /**
     * 新增
     *
     * @param courseEvaluate courseEvaluate
     */
    Boolean createCourseEvaluate(CourseEvaluate courseEvaluate);

    /**
     * 修改
     *
     * @param courseEvaluate courseEvaluate
     */
    Boolean updateCourseEvaluate(CourseEvaluate courseEvaluate);

    /**
     * 删除
     *
     * @param courseEvaluate courseEvaluate
     */
    Boolean deleteCourseEvaluate(CourseEvaluate courseEvaluate);
}
