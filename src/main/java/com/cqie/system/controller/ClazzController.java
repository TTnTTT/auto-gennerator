package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.Clazz;
import com.cqie.system.service.IClazzService;

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
 * 班级 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class ClazzController extends BaseController {

    @Autowired
    private IClazzService clazzService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "clazz")
    public String clazzIndex(){
        return "您的templates目录下的视图文件夹名/clazz/clazz";
    }
*/
    @GetMapping("clazz")
    public ResponseBo getAllClazzs(Clazz clazz) {
        List<Clazz> data=clazzService.findClazzs(clazz);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("clazz/list")
    public ResponseBo clazzList(QueryRequest request, Clazz clazz) {
        IPage<Clazz> data= this.clazzService.findClazzs(request, clazz);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("clazz")
    public ResponseBo addClazz(@Valid Clazz clazz) {
        if(this.clazzService.createClazz(clazz)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("clazz/delete")
    public ResponseBo deleteClazz(Clazz clazz) {
        if(this.clazzService.deleteClazz(clazz)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("clazz/update")
    public ResponseBo updateClazz(Clazz clazz) {
        if(this.clazzService.updateClazz(clazz)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
