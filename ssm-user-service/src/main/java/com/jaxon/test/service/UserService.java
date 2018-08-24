package com.jaxon.test.service;

import com.jaxon.test.po.User;

public interface UserService {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 登陆功能
     * @param user
     * @return
     */
    User findUserByNameAndPassword(User user);
}
