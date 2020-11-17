package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.TeachCourse;
import com.cqie.system.service.ITeachCourseService;

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
 * 老师授课 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class TeachCourseController extends BaseController {

    @Autowired
    private ITeachCourseService teachCourseService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "teachCourse")
    public String teachCourseIndex(){
        return "您的templates目录下的视图文件夹名/teachCourse/teachCourse";
    }
*/
    @GetMapping("teachCourse")
    public ResponseBo getAllTeachCourses(TeachCourse teachCourse) {
        List<TeachCourse> data=teachCourseService.findTeachCourses(teachCourse);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("teachCourse/list")
    public ResponseBo teachCourseList(QueryRequest request, TeachCourse teachCourse) {
        IPage<TeachCourse> data= this.teachCourseService.findTeachCourses(request, teachCourse);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("teachCourse")
    public ResponseBo addTeachCourse(@Valid TeachCourse teachCourse) {
        if(this.teachCourseService.createTeachCourse(teachCourse)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("teachCourse/delete")
    public ResponseBo deleteTeachCourse(TeachCourse teachCourse) {
        if(this.teachCourseService.deleteTeachCourse(teachCourse)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("teachCourse/update")
    public ResponseBo updateTeachCourse(TeachCourse teachCourse) {
        if(this.teachCourseService.updateTeachCourse(teachCourse)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
