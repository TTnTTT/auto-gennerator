package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.CourseEvaluate;
import com.cqie.system.service.ICourseEvaluateService;

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
 * 评教课程、评教辅导员 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class CourseEvaluateController extends BaseController {

    @Autowired
    private ICourseEvaluateService courseEvaluateService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "courseEvaluate")
    public String courseEvaluateIndex(){
        return "您的templates目录下的视图文件夹名/courseEvaluate/courseEvaluate";
    }
*/
    @GetMapping("courseEvaluate")
    public ResponseBo getAllCourseEvaluates(CourseEvaluate courseEvaluate) {
        List<CourseEvaluate> data=courseEvaluateService.findCourseEvaluates(courseEvaluate);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("courseEvaluate/list")
    public ResponseBo courseEvaluateList(QueryRequest request, CourseEvaluate courseEvaluate) {
        IPage<CourseEvaluate> data= this.courseEvaluateService.findCourseEvaluates(request, courseEvaluate);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("courseEvaluate")
    public ResponseBo addCourseEvaluate(@Valid CourseEvaluate courseEvaluate) {
        if(this.courseEvaluateService.createCourseEvaluate(courseEvaluate)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("courseEvaluate/delete")
    public ResponseBo deleteCourseEvaluate(CourseEvaluate courseEvaluate) {
        if(this.courseEvaluateService.deleteCourseEvaluate(courseEvaluate)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("courseEvaluate/update")
    public ResponseBo updateCourseEvaluate(CourseEvaluate courseEvaluate) {
        if(this.courseEvaluateService.updateCourseEvaluate(courseEvaluate)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
