package com.cqie.system.service;

import com.cqie.system.entity.TeachCourse;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 老师授课 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface ITeachCourseService extends IService<TeachCourse> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param teachCourse teachCourse
     * @return IPage<TeachCourse>
     */
    IPage<TeachCourse> findTeachCourses(QueryRequest request, TeachCourse teachCourse);

    /**
     * 查询（所有）
     *
     * @param teachCourse teachCourse
     * @return List<TeachCourse>
     */
    List<TeachCourse> findTeachCourses(TeachCourse teachCourse);

    /**
     * 新增
     *
     * @param teachCourse teachCourse
     */
    Boolean createTeachCourse(TeachCourse teachCourse);

    /**
     * 修改
     *
     * @param teachCourse teachCourse
     */
    Boolean updateTeachCourse(TeachCourse teachCourse);

    /**
     * 删除
     *
     * @param teachCourse teachCourse
     */
    Boolean deleteTeachCourse(TeachCourse teachCourse);
}
