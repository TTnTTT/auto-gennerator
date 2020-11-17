package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.UserRole;
import com.cqie.system.service.IUserRoleService;

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
public class UserRoleController extends BaseController {

    @Autowired
    private IUserRoleService userRoleService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "userRole")
    public String userRoleIndex(){
        return "您的templates目录下的视图文件夹名/userRole/userRole";
    }
*/
    @GetMapping("userRole")
    public ResponseBo getAllUserRoles(UserRole userRole) {
        List<UserRole> data=userRoleService.findUserRoles(userRole);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("userRole/list")
    public ResponseBo userRoleList(QueryRequest request, UserRole userRole) {
        IPage<UserRole> data= this.userRoleService.findUserRoles(request, userRole);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("userRole")
    public ResponseBo addUserRole(@Valid UserRole userRole) {
        if(this.userRoleService.createUserRole(userRole)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("userRole/delete")
    public ResponseBo deleteUserRole(UserRole userRole) {
        if(this.userRoleService.deleteUserRole(userRole)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("userRole/update")
    public ResponseBo updateUserRole(UserRole userRole) {
        if(this.userRoleService.updateUserRole(userRole)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
