package com.service.impl;

import com.dao.MessageDao;
import com.dao.impl.MessageDaoImpl;
import com.entity.Message;
import com.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    MessageDao messageDao = new MessageDaoImpl();

    public List<Message> queryMessageByToUid(Integer id) {
        return messageDao.queryMessageByToUid(id);
    }

    public Message queryMessageById(Integer id) {
        return messageDao.queryMessageById(id);
    }
}
