package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.Course;
import com.cqie.system.mapper.CourseMapper;
import com.cqie.system.service.ICourseService;

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
 * 课程表 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    private final CourseMapper courseMapper;

    @Override
    public IPage<Course> findCourses(QueryRequest request, Course course) {
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Course> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Course> findCourses(Course course) {
	    LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createCourse(Course course) {
        return this.save(course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateCourse(Course course) {
        return this.saveOrUpdate(course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteCourse(Course course) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
