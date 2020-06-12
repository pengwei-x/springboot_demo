package com.peng.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author pengwei
 * @date 2020/6/12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

     private static final Logger logger  =LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void add() {
        logger.info("添加add");
    }

    @Override
    public void delete() {
        logger.info("删除delete");
    }
}
