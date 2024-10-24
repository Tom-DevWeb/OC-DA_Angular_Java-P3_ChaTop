package com.chatop.p3chatop.services;


import com.chatop.p3chatop.models.Message;
import com.chatop.p3chatop.repositories.MessageRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
