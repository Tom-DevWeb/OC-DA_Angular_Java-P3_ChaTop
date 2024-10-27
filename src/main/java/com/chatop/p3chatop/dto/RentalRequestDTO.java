package com.chatop.p3chatop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RentalRequestDTO {
    private String name;

    private BigDecimal surface;

    private BigDecimal price;

    private String  picture;

    private String description;
}
