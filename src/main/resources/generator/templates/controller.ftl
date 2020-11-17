package ${basePackage}.${controllerPackage};

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import ${basePackage}.${entityPackage}.${className};
import ${basePackage}.${servicePackage}.I${className}Service;

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
 * ${tableComment} Controller
 *
 * @author ${author}
 * @date ${date}
 */
@Slf4j
@Validated
@RestController
public class ${className}Controller extends BaseController {

    @Autowired
    private I${className}Service ${className?uncap_first}Service;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "${className?uncap_first}")
    public String ${className?uncap_first}Index(){
        return "您的templates目录下的视图文件夹名/${className?uncap_first}/${className?uncap_first}";
    }
*/
    @GetMapping("${className?uncap_first}")
<#--    @RequiresPermissions("${className?uncap_first}:list")不需要Permissions验证-->
    public ResponseBo getAll${className}s(${className} ${className?uncap_first}) {
        List<${className}> data=${className?uncap_first}Service.find${className}s(${className?uncap_first});
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("${className?uncap_first}/list")
<#--    @RequiresPermissions("${className?uncap_first}:list")-->
    public ResponseBo ${className?uncap_first}List(QueryRequest request, ${className} ${className?uncap_first}) {
        IPage<${className}> data= this.${className?uncap_first}Service.find${className}s(request, ${className?uncap_first});
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("${className?uncap_first}")
<#--    @RequiresPermissions("${className?uncap_first}:add")-->
    public ResponseBo add${className}(@Valid ${className} ${className?uncap_first}) {
        if(this.${className?uncap_first}Service.create${className}(${className?uncap_first})){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("${className?uncap_first}/delete")
<#--    @RequiresPermissions("${className?uncap_first}:delete")-->
    public ResponseBo delete${className}(${className} ${className?uncap_first}) {
        if(this.${className?uncap_first}Service.delete${className}(${className?uncap_first})){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("${className?uncap_first}/update")
<#--    @RequiresPermissions("${className?uncap_first}:update")-->
    public ResponseBo update${className}(${className} ${className?uncap_first}) {
        if(this.${className?uncap_first}Service.update${className}(${className?uncap_first})){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
