package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.MessageRequestDTO;
import com.chatop.p3chatop.dto.MessageResponseDTO;
import com.chatop.p3chatop.services.MessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Message", description = "Message management APIs")
@RequestMapping("/messages")
@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("")
    public ResponseEntity<MessageResponseDTO> createMsg(@Valid @RequestBody MessageRequestDTO messageRequestDTO) {
        MessageResponseDTO response = messageService.createMsg(messageRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
