package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.RoleMenu;
import com.cqie.system.service.IRoleMenuService;

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
 * 角色菜单 Controller
 *
 * @author helit747@gmail.com
 * @date 2020-11-17 12:00:38
 */
@Slf4j
@Validated
@RestController
public class RoleMenuController extends BaseController {

    @Autowired
    private IRoleMenuService roleMenuService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "roleMenu")
    public String roleMenuIndex(){
        return "您的templates目录下的视图文件夹名/roleMenu/roleMenu";
    }
*/
    @GetMapping("roleMenu")
    public ResponseBo getAllRoleMenus(RoleMenu roleMenu) {
        List<RoleMenu> data=roleMenuService.findRoleMenus(roleMenu);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("roleMenu/list")
    public ResponseBo roleMenuList(QueryRequest request, RoleMenu roleMenu) {
        IPage<RoleMenu> data= this.roleMenuService.findRoleMenus(request, roleMenu);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("roleMenu")
    public ResponseBo addRoleMenu(@Valid RoleMenu roleMenu) {
        if(this.roleMenuService.createRoleMenu(roleMenu)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("roleMenu/delete")
    public ResponseBo deleteRoleMenu(RoleMenu roleMenu) {
        if(this.roleMenuService.deleteRoleMenu(roleMenu)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("roleMenu/update")
    public ResponseBo updateRoleMenu(RoleMenu roleMenu) {
        if(this.roleMenuService.updateRoleMenu(roleMenu)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
