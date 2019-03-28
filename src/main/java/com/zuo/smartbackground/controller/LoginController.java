package com.zuo.smartbackground.controller;

import com.zuo.smartbackground.model.User;
import com.zuo.smartbackground.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public User login(User re, HttpServletRequest request, HttpSession session)
    {
        User u = loginService.login(re);
        if(u!=null) {
            Object sessionBrowser = session.getAttribute(u.getAccount());
            if (sessionBrowser == null) {
                System.out.println("不存在session，设置session" + u.getAccount());
                session.setAttribute(u.getAccount(), u.getPassword());
            } else {
                System.out.println("存在session，" +u.getAccount()+"="+ sessionBrowser.toString());
            }
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    System.out.println(cookie.getName() + " : " + cookie.getValue());
                }
            }
            System.out.println("收到" + (n++) + "次登录请求，并成功：" + u.getAccount());
        }
        else{
            System.out.println("收到"+(n++)+"次登录请求，但是失败");
        }
        return u;

    }
}
