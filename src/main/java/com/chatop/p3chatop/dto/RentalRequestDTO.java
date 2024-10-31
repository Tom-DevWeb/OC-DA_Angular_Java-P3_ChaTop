package com.chatop.p3chatop.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
public class RentalRequestDTO {
    private Integer id;
    private String name;
    private BigDecimal surface;
    private BigDecimal price;
    private MultipartFile picture;
    private String description;
}
