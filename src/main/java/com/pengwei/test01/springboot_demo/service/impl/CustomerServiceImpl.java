package com.pengwei.test01.springboot_demo.service.impl;

import com.pengwei.test01.springboot_demo.dao.CustomerMapper;
import com.pengwei.test01.springboot_demo.entity.Customer;
import com.pengwei.test01.springboot_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: pengwei
 * @date: 2020/1/7
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    //直接省略了Dao 层

    @Override
    public Boolean update(Customer customer) {
        int insert = customerMapper.updateByPrimaryKeySelective(customer);
        return insert == 0 ? false : true;

    }

    @Override
    public Customer findOne() {
        return customerMapper.selectByPrimaryKey(1);
    }

    @Override
    public Customer findId(Integer id) {
        return  customerMapper.selectByPrimaryKey(id);
    }
}
