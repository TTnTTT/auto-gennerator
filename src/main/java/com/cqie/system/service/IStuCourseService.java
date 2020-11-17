package com.cqie.system.service;

import com.cqie.system.entity.StuCourse;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 学生上课
 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface IStuCourseService extends IService<StuCourse> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param stuCourse stuCourse
     * @return IPage<StuCourse>
     */
    IPage<StuCourse> findStuCourses(QueryRequest request, StuCourse stuCourse);

    /**
     * 查询（所有）
     *
     * @param stuCourse stuCourse
     * @return List<StuCourse>
     */
    List<StuCourse> findStuCourses(StuCourse stuCourse);

    /**
     * 新增
     *
     * @param stuCourse stuCourse
     */
    Boolean createStuCourse(StuCourse stuCourse);

    /**
     * 修改
     *
     * @param stuCourse stuCourse
     */
    Boolean updateStuCourse(StuCourse stuCourse);

    /**
     * 删除
     *
     * @param stuCourse stuCourse
     */
    Boolean deleteStuCourse(StuCourse stuCourse);
}
