package com.chatop.p3chatop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequestDTO {

    @NotBlank
    private String message;
    @NotNull
    private Long user_id;
    @NotNull
    private Long rental_id;
}
