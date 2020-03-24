package com.pengwei.shardingsphere;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @ResponseBody
    public String index(Model model){
     return "hello";
    }


}
