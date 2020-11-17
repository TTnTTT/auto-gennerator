package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.Course;
import com.cqie.system.service.ICourseService;

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
 * 课程表 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class CourseController extends BaseController {

    @Autowired
    private ICourseService courseService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "course")
    public String courseIndex(){
        return "您的templates目录下的视图文件夹名/course/course";
    }
*/
    @GetMapping("course")
    public ResponseBo getAllCourses(Course course) {
        List<Course> data=courseService.findCourses(course);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("course/list")
    public ResponseBo courseList(QueryRequest request, Course course) {
        IPage<Course> data= this.courseService.findCourses(request, course);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("course")
    public ResponseBo addCourse(@Valid Course course) {
        if(this.courseService.createCourse(course)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("course/delete")
    public ResponseBo deleteCourse(Course course) {
        if(this.courseService.deleteCourse(course)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("course/update")
    public ResponseBo updateCourse(Course course) {
        if(this.courseService.updateCourse(course)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
