package com.pengwei.test01.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: pengwei
 * @date: 2020/1/7
 */

@Controller
@RequestMapping("/index")
public class TestController {

    @RequestMapping("/test")
    public String index(){
        return "index";
    }
}
