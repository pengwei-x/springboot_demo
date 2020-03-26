package com.pengwei.shardingsphere.controller;

import com.pengwei.shardingsphere.bean.User;
import com.pengwei.shardingsphere.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        User user = new User();
        user.setName("pengwei2");
        user.setSex(0);
        user.setPassword("1111");
        user.setCreateTime(new Date());
        user.setEmail("752383018@qq.com");
        user.setCityId(222);
        userService.save(user);
        return "success";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public User getId(@PathVariable Long id) {
        System.out.println("-----------------" + id);
        User user = userService.get(id);
        System.out.println(user.getId());
        return user;
    }

    @RequestMapping("/get")
    @ResponseBody
    public User get() {
        User user = userService.get(449559178051059712L);
        System.out.println(user.getId());
        return user;
    }

}
