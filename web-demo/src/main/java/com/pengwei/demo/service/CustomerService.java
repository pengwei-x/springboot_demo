package com.pengwei.demo.service;


import com.pengwei.demo.entity.Customer;

/**
 * @author: pengwei
 * @date: 2020/1/7
 */
public interface CustomerService {
     Boolean update(Customer customer);
     Customer findOne();
     Customer findId(Integer id);
}
