package com.i2i.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Builder
public class ProductResponseCollectionDTO extends BaseResponseDto {
    private Collection<ProductResponseDTO> products;
}
