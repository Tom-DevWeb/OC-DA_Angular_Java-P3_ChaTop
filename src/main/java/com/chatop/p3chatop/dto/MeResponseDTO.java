package com.chatop.p3chatop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MeResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private Date created_at;
    private Date updated_at;
}
