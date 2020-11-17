package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.CourseEvaluate;
import com.cqie.system.mapper.CourseEvaluateMapper;
import com.cqie.system.service.ICourseEvaluateService;

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
 * 评教课程、评教辅导员 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseEvaluateServiceImpl extends ServiceImpl<CourseEvaluateMapper, CourseEvaluate> implements ICourseEvaluateService {

    private final CourseEvaluateMapper courseEvaluateMapper;

    @Override
    public IPage<CourseEvaluate> findCourseEvaluates(QueryRequest request, CourseEvaluate courseEvaluate) {
        LambdaQueryWrapper<CourseEvaluate> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<CourseEvaluate> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<CourseEvaluate> findCourseEvaluates(CourseEvaluate courseEvaluate) {
	    LambdaQueryWrapper<CourseEvaluate> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createCourseEvaluate(CourseEvaluate courseEvaluate) {
        return this.save(courseEvaluate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateCourseEvaluate(CourseEvaluate courseEvaluate) {
        return this.saveOrUpdate(courseEvaluate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteCourseEvaluate(CourseEvaluate courseEvaluate) {
        LambdaQueryWrapper<CourseEvaluate> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
