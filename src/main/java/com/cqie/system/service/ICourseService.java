package com.cqie.system.service;

import com.cqie.system.entity.Course;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 课程表 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface ICourseService extends IService<Course> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param course course
     * @return IPage<Course>
     */
    IPage<Course> findCourses(QueryRequest request, Course course);

    /**
     * 查询（所有）
     *
     * @param course course
     * @return List<Course>
     */
    List<Course> findCourses(Course course);

    /**
     * 新增
     *
     * @param course course
     */
    Boolean createCourse(Course course);

    /**
     * 修改
     *
     * @param course course
     */
    Boolean updateCourse(Course course);

    /**
     * 删除
     *
     * @param course course
     */
    Boolean deleteCourse(Course course);
}
