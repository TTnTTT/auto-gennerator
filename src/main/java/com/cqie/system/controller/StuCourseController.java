package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.StuCourse;
import com.cqie.system.service.IStuCourseService;

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
 * 学生上课
 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class StuCourseController extends BaseController {

    @Autowired
    private IStuCourseService stuCourseService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "stuCourse")
    public String stuCourseIndex(){
        return "您的templates目录下的视图文件夹名/stuCourse/stuCourse";
    }
*/
    @GetMapping("stuCourse")
    public ResponseBo getAllStuCourses(StuCourse stuCourse) {
        List<StuCourse> data=stuCourseService.findStuCourses(stuCourse);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("stuCourse/list")
    public ResponseBo stuCourseList(QueryRequest request, StuCourse stuCourse) {
        IPage<StuCourse> data= this.stuCourseService.findStuCourses(request, stuCourse);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("stuCourse")
    public ResponseBo addStuCourse(@Valid StuCourse stuCourse) {
        if(this.stuCourseService.createStuCourse(stuCourse)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("stuCourse/delete")
    public ResponseBo deleteStuCourse(StuCourse stuCourse) {
        if(this.stuCourseService.deleteStuCourse(stuCourse)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("stuCourse/update")
    public ResponseBo updateStuCourse(StuCourse stuCourse) {
        if(this.stuCourseService.updateStuCourse(stuCourse)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
