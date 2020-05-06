package com.pengwei.shardingsphere.service.impl;

import com.pengwei.shardingsphere.bean.User;
import com.pengwei.shardingsphere.bean.UserExample;
import com.pengwei.shardingsphere.mapper.UserMapper;
import com.pengwei.shardingsphere.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public User get(Long id) {
        // TODO Auto-generated method stub
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }


}
