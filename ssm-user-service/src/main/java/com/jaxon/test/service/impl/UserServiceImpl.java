package com.jaxon.test.service.impl;

import com.jaxon.test.dao.UserDao;
import com.jaxon.test.po.User;
import com.jaxon.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user) {
        userDao.addUser(user);
    }

    /**
     * 登陆功能
     *
     * @param user
     * @return
     */
    @Override
    public User findUserByNameAndPassword(User user) {

        return userDao.findUserByNameAndPassword(user);
    }
}
