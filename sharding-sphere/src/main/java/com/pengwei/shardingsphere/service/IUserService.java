package com.pengwei.shardingsphere.service;

		import com.pengwei.shardingsphere.bean.User;

public interface IUserService {

	void save(User user);

	User get(Long l);
}
