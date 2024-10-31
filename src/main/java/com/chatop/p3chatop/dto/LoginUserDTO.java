package com.chatop.p3chatop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoginUserDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
