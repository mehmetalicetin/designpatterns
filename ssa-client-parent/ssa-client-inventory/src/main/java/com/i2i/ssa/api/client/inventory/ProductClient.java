package com.i2i.ssa.api.client.inventory;



import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "product-service", url = "${product.service.url}")
public interface ProductClient {

    @GetMapping("/api/v1/product")
    ResponseEntity<ProductResponseCollectionDTO> getProducts();

    @GetMapping("/api/v1/product/{id}")
    ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id);

    @PutMapping("/api/v1/product/{id}/use/{quantity}")
    ResponseEntity<Void> decrementQuantity(@PathVariable("id") UUID id,
                                         @PathVariable("quantity") Integer quantity);

    @PostMapping("/api/v1/product")
    ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO requestProductDto);
}