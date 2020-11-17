package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.Options;
import com.cqie.system.service.IOptionsService;

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
 *  Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class OptionsController extends BaseController {

    @Autowired
    private IOptionsService optionsService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "options")
    public String optionsIndex(){
        return "您的templates目录下的视图文件夹名/options/options";
    }
*/
    @GetMapping("options")
    public ResponseBo getAllOptionss(Options options) {
        List<Options> data=optionsService.findOptionss(options);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("options/list")
    public ResponseBo optionsList(QueryRequest request, Options options) {
        IPage<Options> data= this.optionsService.findOptionss(request, options);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("options")
    public ResponseBo addOptions(@Valid Options options) {
        if(this.optionsService.createOptions(options)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("options/delete")
    public ResponseBo deleteOptions(Options options) {
        if(this.optionsService.deleteOptions(options)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("options/update")
    public ResponseBo updateOptions(Options options) {
        if(this.optionsService.updateOptions(options)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
