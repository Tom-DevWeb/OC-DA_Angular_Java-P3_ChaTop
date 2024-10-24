package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.models.Message;
import com.chatop.p3chatop.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     *
     */

    @PostMapping("/")
    public Message addMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
