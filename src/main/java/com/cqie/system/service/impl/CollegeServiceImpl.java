package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.College;
import com.cqie.system.mapper.CollegeMapper;
import com.cqie.system.service.ICollegeService;

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
 * 学院表 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {

    private final CollegeMapper collegeMapper;

    @Override
    public IPage<College> findColleges(QueryRequest request, College college) {
        LambdaQueryWrapper<College> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<College> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<College> findColleges(College college) {
	    LambdaQueryWrapper<College> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createCollege(College college) {
        return this.save(college);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateCollege(College college) {
        return this.saveOrUpdate(college);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteCollege(College college) {
        LambdaQueryWrapper<College> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
