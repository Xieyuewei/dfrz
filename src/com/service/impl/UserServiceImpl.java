package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    public int register(User user) {
        return userDao.insert(user);
    }

    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }
}
