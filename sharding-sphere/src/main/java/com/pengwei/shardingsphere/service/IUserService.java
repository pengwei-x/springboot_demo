package com.pengwei.shardingsphere.service;

import com.pengwei.shardingsphere.bean.User;

import java.util.List;

public interface IUserService {

	void save(User user);

	User get(Long id);

	List<User> getAll();
}
