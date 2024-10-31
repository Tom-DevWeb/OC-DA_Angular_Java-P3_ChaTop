package com.chatop.p3chatop.services;

import com.chatop.p3chatop.dto.MessageRequestDTO;
import com.chatop.p3chatop.dto.MessageResponseDTO;
import com.chatop.p3chatop.entities.Message;
import com.chatop.p3chatop.mappers.MessageMapper;
import com.chatop.p3chatop.repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(
            MessageRepository messageRepository,
            MessageMapper messageMapper
    ) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public MessageResponseDTO createMsg(MessageRequestDTO messageRequestDTO) {
        Message message = messageMapper.toMessage(messageRequestDTO);

        messageRepository.save(message);

        return new MessageResponseDTO("Message send with success!");
    }
}
