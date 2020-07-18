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
        user.setId(163423211L);
        user.setName("hao");
        user.setEmail("1111@qq.com");
        user.setCityId(2222L);
        user.setSex(0);
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
        User user = userService.get(449559644428304384L);
        System.out.println("----" + user.toString());
    }

}
