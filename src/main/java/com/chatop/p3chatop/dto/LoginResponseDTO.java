package com.chatop.p3chatop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String token;

    private Long expiresIn;

}