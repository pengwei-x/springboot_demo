package com.pengwei.demo.controller;


import com.pengwei.demo.aop.SystemLog;
import com.pengwei.demo.entity.Customer;
import com.pengwei.demo.service.CustomerService;
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
@RequestMapping("/")
public class TestController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/test1")
    public String index(Model model){
        Customer one = customerService.findOne();
        model.addAttribute("customer",one);
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String index(){

        return "hello";
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
    @SystemLog(role="客户")
    public Customer  update(Customer customer){
        Boolean result = customerService.update(customer);
        return customer;
    }

    public static void main(String[] args) {
    }
}
