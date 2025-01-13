package com.i2i.ssa.api.client.cart;

import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "cart-service", url = "${cart.service.url}")
public interface CartClient {

    @GetMapping("/api/v1/cart/{id}/add/{productId}/{quantity}")
	ResponseEntity<Void> addProductWithGivenIdAndGivenQuantityToCart(@PathVariable("id") UUID id, @PathVariable("productId") UUID productId,
            @PathVariable("quantity") Integer quantity);

    @PostMapping(value = "/api/v1/cart/{id}/remove/{productId}/{quantity}")
    ResponseEntity<Void> removeProductWithGivenIdAndGivenQuantityToCart(@PathVariable("id") UUID id, @PathVariable("productId") UUID productId,
            @PathVariable("quantity") Integer quantity);

    @GetMapping("/api/v1/cart/{id}")
    ResponseEntity<CartResponseDTO> getCartById(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/cart")
    ResponseEntity<UUID> create(@RequestBody CartRequestDTO requestCustomerDto);

    @DeleteMapping(value = "/api/v1/cart/{id}")
    ResponseEntity<Void> deleteCartById(@PathVariable("id") UUID id);
}