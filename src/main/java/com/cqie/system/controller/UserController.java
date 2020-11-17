package com.cqie.system.controller;

import com.cqie.autogener.common.controller.BaseController;
import com.cqie.autogener.common.entity.QueryRequest;
import com.cqie.autogener.common.entity.ResponseBo;
import com.cqie.system.entity.User;
import com.cqie.system.service.IUserService;

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
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;
/**如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
    @GetMapping("您的templates目录下的视图文件夹名" + "user")
    public String userIndex(){
        return "您的templates目录下的视图文件夹名/user/user";
    }
*/
    @GetMapping("user")
    public ResponseBo getAllUsers(User user) {
        List<User> data=userService.findUsers(user);
        if(data != null){
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping("user/list")
    public ResponseBo userList(QueryRequest request, User user) {
        IPage<User> data= this.userService.findUsers(request, user);
        if (data != null){
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping("user")
    public ResponseBo addUser(@Valid User user) {
        if(this.userService.createUser(user)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }


    @GetMapping("user/delete")
    public ResponseBo deleteUser(User user) {
        if(this.userService.deleteUser(user)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

    @PostMapping("user/update")
    public ResponseBo updateUser(User user) {
        if(this.userService.updateUser(user)){
            return ResponseBo.ok();
        }else{
            return ResponseBo.fail();
        }
    }

}
