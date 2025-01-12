package com.i2i.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductResponseDTO extends BaseResponseDto{
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Double discount;
    private Integer stockQuantity;
    private String imageUrl;
}
