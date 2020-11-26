package com.dao.impl;

import com.dao.BaseDao;
import com.dao.MessageDao;
import com.entity.Message;

import java.util.List;

public class MessageDaoImpl extends BaseDao implements MessageDao {
    public int insert(Message message) {
        String sql = "INSERT INTO `t_msg` (`fromuid`,`touid`,`mtitle`,`mcontent`,`readFlag`,`createtime`) VALUES (?, ?, ?, ?, ?, ?)";
        return update(sql,message.getFromUid(),message.getToUid(),message.getMtitle(),message.getmContent(),message.getReadFlag(),message.getCreateTime());
    }

    public int update(Message message) {
        String sql = "UPDATE `t_msg` SET `fromuid` = ?,`touid` = ?,`mtitle` = ?,`mcontent` = ?,`readFlag` = ?,`createtime` = ? WHERE `id` = ?";
        return update(sql,message.getFromUid(),message.getToUid(),message.getMtitle(),message.getmContent(),message.getReadFlag(),message.getCreateTime(),message.getId());
    }

    public int delete(Integer id) {
        String sql = "DELETE FROM `t_msg` WHERE `id` = ?";
        return update(sql,id);
    }

    public List<Message> queryAll() {
        String sql = "SELECT * FROM `t_msg`";
        return queryForList(Message.class,sql);
    }

    public Message queryMessageById(Integer id) {
        String sql = "SELECT * FROM `t_msg` WHERE `id` = ?";
        return queryForOne(Message.class,sql,id);
    }

    public List<Message> queryMessageByToUid(Integer id) {
        String sql = "SELECT * FROM `t_msg` WHERE `touid` = ?";
        return queryForList(Message.class,sql,id);
    }


}
