package com.zuo.smartbackground.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntercepterAuth  extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        System.out.println("前置拦截器1 preHandle： 请求的uri为："+requestURL.toString());
        Cookie [] cookies = httpServletRequest.getCookies();
        if(cookies!=null){
            for (Cookie c:cookies){
                System.out.println(c.getName()+":"+c.getValue());
                if("vxflag".equals(c.getName())){
                    if("f71e5f1e08cd5a7e42a7e9aa70d22458".equals(c.getValue())){
                        return true;
                    }
                }
            }
        }
        logger.info("验证失败");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1 postHandle： ");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器1 afterCompletion： ");
    }
}