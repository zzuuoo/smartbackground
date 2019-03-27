package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.User;
import com.zuo.smartbackground.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 登录验证
 */
@CrossOrigin//跨域
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    public static  int n = 1;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(User re)
    {
        User u = loginService.login(re);
        if(u!=null) {
            System.out.println("收到" + (n++) + "次登录请求，并成功：" + u.getAccount());
        }
        else{
            System.out.println("收到"+(n++)+"次登录请求，但是失败");
        }
        return u;

    }
}
