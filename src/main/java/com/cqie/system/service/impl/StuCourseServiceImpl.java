package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.StuCourse;
import com.cqie.system.mapper.StuCourseMapper;
import com.cqie.system.service.IStuCourseService;

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
 * 学生上课
 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StuCourseServiceImpl extends ServiceImpl<StuCourseMapper, StuCourse> implements IStuCourseService {

    private final StuCourseMapper stuCourseMapper;

    @Override
    public IPage<StuCourse> findStuCourses(QueryRequest request, StuCourse stuCourse) {
        LambdaQueryWrapper<StuCourse> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<StuCourse> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<StuCourse> findStuCourses(StuCourse stuCourse) {
	    LambdaQueryWrapper<StuCourse> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createStuCourse(StuCourse stuCourse) {
        return this.save(stuCourse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateStuCourse(StuCourse stuCourse) {
        return this.saveOrUpdate(stuCourse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteStuCourse(StuCourse stuCourse) {
        LambdaQueryWrapper<StuCourse> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
