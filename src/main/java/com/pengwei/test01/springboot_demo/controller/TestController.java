package com.pengwei.test01.springboot_demo.controller;

import com.pengwei.test01.springboot_demo.entity.Customer;
import com.pengwei.test01.springboot_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/test")
    public String index(){
        return "index";
    }

    @RequestMapping("/find")
    @ResponseBody
    public Customer fingCustomer(){
        Customer one = customerService.findOne();
        return one;
    }
}
