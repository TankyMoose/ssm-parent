package com.jaxon.test.dao;

import com.jaxon.test.po.User;

public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户名和密码查找用户
     * @param user
     * @return
     */
    User findUserByNameAndPassword(User user);
}
