package com.i2i.ssa.api.inventory.controller;

import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import com.i2i.ssa.api.core.controller.BaseController;
import com.i2i.ssa.api.inventory.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProductController extends BaseController<ProductService> implements ProductApi {
    public ProductController(ProductService service) {
        super(service);
    }

    @Override
    public ResponseEntity<ProductResponseCollectionDTO> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @Override
    public ResponseEntity<ProductResponseDTO> getProductById(UUID id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @Override
    public ResponseEntity<Void> decrementQuantity(UUID id, Integer quantity) {
        service.decrementQuantity(id, quantity);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductResponseDTO> create(ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(service.create(productRequestDTO));
    }
}
