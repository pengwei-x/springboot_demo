package com.pengwei.shardingsphere;

import com.pengwei.shardingsphere.bean.User;
import com.pengwei.shardingsphere.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ShardingSphereApplicationTests {

    @Test
    public void contextLoads() {

        int a = 3 % 4;
    }


    @Autowired
    private IUserService userService;

    @Test
    public void saveUser() {
        User user = new User();
        user.setId(16342322L);
        user.setName("张三");
        user.setEmail("");
        user.setCityId(2221L);
        user.setSex(1);
        userService.save(user);
    }

    @Test
    public void getAll() {
        List<User> userList = userService.getAll();
        for (User user : userList) {
            System.out.println("----" + user.toString());
        }
    }

    @Test
    public void getUser() {
        User user = userService.get(16342322L);
        System.out.println("----" + user.toString());
    }

}
