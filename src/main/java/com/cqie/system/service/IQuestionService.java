package com.cqie.system.service;

import com.cqie.system.entity.Question;
import com.cqie.autogener.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 评教题目 Service接口
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
public interface IQuestionService extends IService<Question> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param question question
     * @return IPage<Question>
     */
    IPage<Question> findQuestions(QueryRequest request, Question question);

    /**
     * 查询（所有）
     *
     * @param question question
     * @return List<Question>
     */
    List<Question> findQuestions(Question question);

    /**
     * 新增
     *
     * @param question question
     */
    Boolean createQuestion(Question question);

    /**
     * 修改
     *
     * @param question question
     */
    Boolean updateQuestion(Question question);

    /**
     * 删除
     *
     * @param question question
     */
    Boolean deleteQuestion(Question question);
}
