package com.pengwei.test01.springboot_demo.controller;

import com.pengwei.test01.springboot_demo.entity.Customer;
import com.pengwei.test01.springboot_demo.service.CustomerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/test")
    public String index(Model model){
        Customer one = customerService.findOne();
        model.addAttribute("customer",one);
        return "index";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String fingCustomer(){
        Customer one = customerService.findOne();
        JSONObject jsonResult=new JSONObject();
        jsonResult.put("data",one);
        return jsonResult.toString();
    }

    @RequestMapping("update" )
    @ResponseBody
    public boolean  update(Customer customer){
        Boolean result = customerService.update(customer);
        return result;
    }
}
