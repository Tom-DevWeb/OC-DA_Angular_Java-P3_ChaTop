package com.chatop.p3chatop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
public class RentalResponseDTO {
    private Integer id;

    private String name;

    private BigDecimal surface;

    private BigDecimal price;

    private String picture;

    private String description;

    private Integer ownerId;

    private Date createdAt;

    private Date updatedAt;
}
