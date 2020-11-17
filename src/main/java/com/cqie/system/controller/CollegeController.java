package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.College;
import com.cqie.system.service.ICollegeService;

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
 * 学院表 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class CollegeController extends BaseController {

    @Autowired
    private ICollegeService collegeService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "college")
    public String collegeIndex(){
        return "您的templates目录下的视图文件夹名/college/college";
    }
*/
    @GetMapping("college")
    public ResponseBo getAllColleges(College college) {
        List<College> data=collegeService.findColleges(college);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("college/list")
    public ResponseBo collegeList(QueryRequest request, College college) {
        IPage<College> data= this.collegeService.findColleges(request, college);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("college")
    public ResponseBo addCollege(@Valid College college) {
        if(this.collegeService.createCollege(college)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("college/delete")
    public ResponseBo deleteCollege(College college) {
        if(this.collegeService.deleteCollege(college)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("college/update")
    public ResponseBo updateCollege(College college) {
        if(this.collegeService.updateCollege(college)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
