package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.Role;
import com.cqie.system.service.IRoleService;

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
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "role")
    public String roleIndex(){
        return "您的templates目录下的视图文件夹名/role/role";
    }
*/
    @GetMapping("role")
    public ResponseBo getAllRoles(Role role) {
        List<Role> data=roleService.findRoles(role);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("role/list")
    public ResponseBo roleList(QueryRequest request, Role role) {
        IPage<Role> data= this.roleService.findRoles(request, role);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("role")
    public ResponseBo addRole(@Valid Role role) {
        if(this.roleService.createRole(role)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("role/delete")
    public ResponseBo deleteRole(Role role) {
        if(this.roleService.deleteRole(role)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("role/update")
    public ResponseBo updateRole(Role role) {
        if(this.roleService.updateRole(role)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
