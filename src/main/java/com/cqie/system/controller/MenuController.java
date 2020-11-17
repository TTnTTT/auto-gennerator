package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.Menu;
import com.cqie.system.service.IMenuService;

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
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "menu")
    public String menuIndex(){
        return "您的templates目录下的视图文件夹名/menu/menu";
    }
*/
    @GetMapping("menu")
    public ResponseBo getAllMenus(Menu menu) {
        List<Menu> data=menuService.findMenus(menu);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("menu/list")
    public ResponseBo menuList(QueryRequest request, Menu menu) {
        IPage<Menu> data= this.menuService.findMenus(request, menu);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("menu")
    public ResponseBo addMenu(@Valid Menu menu) {
        if(this.menuService.createMenu(menu)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("menu/delete")
    public ResponseBo deleteMenu(Menu menu) {
        if(this.menuService.deleteMenu(menu)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("menu/update")
    public ResponseBo updateMenu(Menu menu) {
        if(this.menuService.updateMenu(menu)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
