package com.zuo.smartbackground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/a")
    public String getSttt()
    {
        return "左树才";
    }
}
