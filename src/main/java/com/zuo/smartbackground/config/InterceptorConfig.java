package com.zuo.smartbackground.config;

import com.sun.javaws.jnl.LibraryDesc;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePath = new ArrayList<>();
        excludePath.add("/login");
        excludePath.add("/checkOk");
        List<String> path = new ArrayList<>();
        path.add("/checkIntercept");
        registry.addInterceptor(new IntercepterAuth()).addPathPatterns(path).excludePathPatterns(excludePath);
    }
}
