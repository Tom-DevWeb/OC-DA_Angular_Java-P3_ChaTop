package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.MessageRequestDTO;
import com.chatop.p3chatop.dto.MessageResponseDTO;
import com.chatop.p3chatop.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @Operation(
            summary = "Créer un nouveau message",
            description = "Permet de créer un nouveau message avec les informations fournies.",
            security = { @SecurityRequirement(name = "Bearer Authentication") }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = { @Content(schema = @Schema(implementation = MessageResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "401",
                    content = { @Content(schema = @Schema()) })
    })
    @PostMapping("")
    public ResponseEntity<MessageResponseDTO> createMsg(@Valid @RequestBody MessageRequestDTO messageRequestDTO) {
        MessageResponseDTO response = messageService.createMsg(messageRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
