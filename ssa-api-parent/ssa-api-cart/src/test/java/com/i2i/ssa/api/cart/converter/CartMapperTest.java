package com.i2i.ssa.api.cart.converter;

import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.ssa.api.cart.mapper.CartItemMapper;
import com.i2i.ssa.api.cart.mapper.CartMapper;
import com.i2i.ssa.api.cart.model.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CartMapperTest {
	private CartMapper cartMapper;

	@BeforeEach
	void setUp() {
		CartItemMapper cartItemMapper = new CartItemMapper();
		cartMapper = new CartMapper(cartItemMapper);
	}
	@Test
	void toCart() {
		UUID customerId = UUID.randomUUID();
		CartRequestDTO cartRequestDTO = CartRequestDTO.builder().customerId(customerId).build();
		Cart cart = cartMapper.toCart(cartRequestDTO);
		assertNotNull(cart);
		assertEquals(customerId, cart.getCustomerId());
	}

	@Test
	void toCartResponseDTO() {
		UUID customerId = UUID.randomUUID();
		Cart cart = Cart.builder().customerId(customerId).build();
		CartResponseDTO cartResponseDTO = cartMapper.toCartResponseDTO(cart);
		assertNotNull(cartResponseDTO);
		assertEquals(customerId, cartResponseDTO.getCustomerId());
	}
}