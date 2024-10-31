package com.chatop.p3chatop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
public class RentalRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal surface;
    @NotNull
    private BigDecimal price;
    private MultipartFile picture;
    @NotBlank
    private String description;
}
