package com.dao.impl;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    public int insert(User user) {
        String sql = "INSERT INTO `t_user` (`username`,`password`,`email`) VALUES (?, ?, ?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    public int update(User user) {
        String sql = "UPDATE `t_user` SET `username` = ?,`password` = ?,`email` = ? WHERE `id` = ?";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getId());
    }

    public int delete(Integer id) {
        String sql = "DELETE FROM `t_user` WHERE `id` = ?";
        return update(sql, id);
    }

    public List<User> queryAll() {
        String sql = "SELECT * FROM `t_user`";
        return null;
    }

    public User queryUserById(Integer id) {
        String sql = "SELECT * FROM `t_user` WHERE `id` = ?";
        return queryForOne(User.class,sql,id);
    }

    public User queryUserByNameAndPassword(User user) {
        String sql = "SELECT * FROM `t_user` WHERE `username` = ? AND `password` = ?";
        return queryForOne(User.class,sql,user.getUsername(),user.getPassword());
    }
}
