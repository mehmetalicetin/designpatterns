package com.i2i.ssa.api.inventory.convert;

import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import com.i2i.ssa.api.inventory.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public ProductResponseCollectionDTO toProductResponseCollectionDTO(Iterable<Product> products) {
        List<ProductResponseDTO> dtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDTO dto = toProductResponseDTO(product);
            dtos.add(dto);
        }
        return ProductResponseCollectionDTO.builder().products(dtos).build();
    }

    public ProductResponseDTO toProductResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .build();
    }


    public Product toProduct(ProductRequestDTO productRequestDTO) {
        return Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .stockQuantity(productRequestDTO.getStockQuantity())
                .build();
    }

}
