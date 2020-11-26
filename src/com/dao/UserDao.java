package com.dao;

import com.entity.User;

import java.util.List;

public interface UserDao {
    int insert(User user);

    int update(User user);

    int delete(Integer id);

    List<User> queryAll();

    User queryUserById(Integer id);

    User queryUserByNameAndPassword(User user);
}
