package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.TeachCourse;
import com.cqie.system.mapper.TeachCourseMapper;
import com.cqie.system.service.ITeachCourseService;

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
 * 老师授课 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeachCourseServiceImpl extends ServiceImpl<TeachCourseMapper, TeachCourse> implements ITeachCourseService {

    private final TeachCourseMapper teachCourseMapper;

    @Override
    public IPage<TeachCourse> findTeachCourses(QueryRequest request, TeachCourse teachCourse) {
        LambdaQueryWrapper<TeachCourse> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<TeachCourse> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<TeachCourse> findTeachCourses(TeachCourse teachCourse) {
	    LambdaQueryWrapper<TeachCourse> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createTeachCourse(TeachCourse teachCourse) {
        return this.save(teachCourse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTeachCourse(TeachCourse teachCourse) {
        return this.saveOrUpdate(teachCourse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteTeachCourse(TeachCourse teachCourse) {
        LambdaQueryWrapper<TeachCourse> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
