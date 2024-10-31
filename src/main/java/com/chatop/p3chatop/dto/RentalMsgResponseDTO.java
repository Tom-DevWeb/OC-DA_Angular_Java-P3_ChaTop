package com.chatop.p3chatop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalMsgResponseDTO {
    private String message;

    public RentalMsgResponseDTO(String message) {
        this.message = message;
    }
}
