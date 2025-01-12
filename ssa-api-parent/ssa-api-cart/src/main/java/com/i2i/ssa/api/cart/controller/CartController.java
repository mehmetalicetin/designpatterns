package com.i2i.ssa.api.cart.controller;


import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.ssa.api.cart.service.CartService;
import com.i2i.ssa.api.core.controller.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CartController extends BaseController<CartService> implements CartApi{
	protected CartController(CartService service) {
		super(service);
	}

	@Override
	public ResponseEntity<UUID> create(CartRequestDTO cartRequestDTO) {
		return ResponseEntity.ok(service.create(cartRequestDTO));
	}

	@Override
	public ResponseEntity<CartResponseDTO> getCartById(UUID id) {
		return ResponseEntity.ok(service.getCartById(id));
	}

	@Override
	public ResponseEntity<Void> addProductWithGivenIdAndGivenQuantityToCart(UUID id, UUID productId, Integer quantity) {
		service.addProductWithGivenIdAndGivenQuantityToCart(id, productId, quantity);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Void> removeProductWithGivenIdAndGivenQuantityToCart(UUID id, UUID productId, Integer quantity) {
		service.removeProductWithGivenIdAndGivenQuantityToCart(id, productId, quantity);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Void> deleteCartById(UUID id) {
		service.deleteCartById(id);
		return ResponseEntity.noContent().build();
	}
}
