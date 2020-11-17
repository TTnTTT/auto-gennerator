package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.EvaluateRecord;
import com.cqie.system.service.IEvaluateRecordService;

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
public class EvaluateRecordController extends BaseController {

    @Autowired
    private IEvaluateRecordService evaluateRecordService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "evaluateRecord")
    public String evaluateRecordIndex(){
        return "您的templates目录下的视图文件夹名/evaluateRecord/evaluateRecord";
    }
*/
    @GetMapping("evaluateRecord")
    public ResponseBo getAllEvaluateRecords(EvaluateRecord evaluateRecord) {
        List<EvaluateRecord> data=evaluateRecordService.findEvaluateRecords(evaluateRecord);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("evaluateRecord/list")
    public ResponseBo evaluateRecordList(QueryRequest request, EvaluateRecord evaluateRecord) {
        IPage<EvaluateRecord> data= this.evaluateRecordService.findEvaluateRecords(request, evaluateRecord);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("evaluateRecord")
    public ResponseBo addEvaluateRecord(@Valid EvaluateRecord evaluateRecord) {
        if(this.evaluateRecordService.createEvaluateRecord(evaluateRecord)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("evaluateRecord/delete")
    public ResponseBo deleteEvaluateRecord(EvaluateRecord evaluateRecord) {
        if(this.evaluateRecordService.deleteEvaluateRecord(evaluateRecord)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("evaluateRecord/update")
    public ResponseBo updateEvaluateRecord(EvaluateRecord evaluateRecord) {
        if(this.evaluateRecordService.updateEvaluateRecord(evaluateRecord)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
