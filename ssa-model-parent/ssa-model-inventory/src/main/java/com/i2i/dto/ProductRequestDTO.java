package com.i2i.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductRequestDTO extends BaseRequestDto{
    private String name;
    private String description;
    private Double price;
    private Double discount;
    private Integer stockQuantity;
    private String imageUrl;
}
