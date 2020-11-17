package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.Question;
import com.cqie.system.service.IQuestionService;

import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 评教题目 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class QuestionController extends BaseController {

    @Autowired
    private IQuestionService questionService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "question")
    public String questionIndex(){
        return "您的templates目录下的视图文件夹名/question/question";
    }
*/
    @GetMapping("question")
    public ResponseBo getAllQuestions(Question question) {
        List<Question> data=questionService.findQuestions(question);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("question/list")
    public ResponseBo questionList(QueryRequest request, Question question) {
        IPage<Question> data= this.questionService.findQuestions(request, question);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("question")
    public ResponseBo addQuestion(@Valid Question question) {
        if(this.questionService.createQuestion(question)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("question/delete")
    public ResponseBo deleteQuestion(Question question) {
        if(this.questionService.deleteQuestion(question)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("question/update")
    public ResponseBo updateQuestion(Question question) {
        if(this.questionService.updateQuestion(question)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
