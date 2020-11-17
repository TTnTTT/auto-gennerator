package com.cqie.system.service.impl;

import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.system.entity.Question;
import com.cqie.system.mapper.QuestionMapper;
import com.cqie.system.service.IQuestionService;

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
 * 评教题目 Service实现
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    private final QuestionMapper questionMapper;

    @Override
    public IPage<Question> findQuestions(QueryRequest request, Question question) {
        LambdaQueryWrapper<Question> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Question> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Question> findQuestions(Question question) {
	    LambdaQueryWrapper<Question> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createQuestion(Question question) {
        return this.save(question);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateQuestion(Question question) {
        return this.saveOrUpdate(question);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteQuestion(Question question) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
