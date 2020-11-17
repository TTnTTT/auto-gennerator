package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.EvaluateRecords;
import com.cqie.system.service.IEvaluateRecordsService;

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
public class EvaluateRecordsController extends BaseController {

    @Autowired
    private IEvaluateRecordsService evaluateRecordsService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "evaluateRecords")
    public String evaluateRecordsIndex(){
        return "您的templates目录下的视图文件夹名/evaluateRecords/evaluateRecords";
    }
*/
    @GetMapping("evaluateRecords")
    public ResponseBo getAllEvaluateRecordss(EvaluateRecords evaluateRecords) {
        List<EvaluateRecords> data=evaluateRecordsService.findEvaluateRecordss(evaluateRecords);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("evaluateRecords/list")
    public ResponseBo evaluateRecordsList(QueryRequest request, EvaluateRecords evaluateRecords) {
        IPage<EvaluateRecords> data= this.evaluateRecordsService.findEvaluateRecordss(request, evaluateRecords);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("evaluateRecords")
    public ResponseBo addEvaluateRecords(@Valid EvaluateRecords evaluateRecords) {
        if(this.evaluateRecordsService.createEvaluateRecords(evaluateRecords)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("evaluateRecords/delete")
    public ResponseBo deleteEvaluateRecords(EvaluateRecords evaluateRecords) {
        if(this.evaluateRecordsService.deleteEvaluateRecords(evaluateRecords)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("evaluateRecords/update")
    public ResponseBo updateEvaluateRecords(EvaluateRecords evaluateRecords) {
        if(this.evaluateRecordsService.updateEvaluateRecords(evaluateRecords)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
