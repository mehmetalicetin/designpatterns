package com.i2i.ssa.api.cart.converter;

import com.i2i.dto.cartItem.CartItemRequestCollectionDTO;
import com.i2i.dto.cartItem.CartItemRequestDTO;
import com.i2i.ssa.api.cart.mapper.CartItemMapper;
import com.i2i.ssa.api.cart.model.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CartItemMapperTest {
	private CartItemMapper cartItemMapper;

	@BeforeEach
	void setUp() {
		cartItemMapper = new CartItemMapper();
	}

	@Test
	void toCartItem() {
		UUID uuid = UUID.randomUUID();
		CartItemRequestDTO dto = CartItemRequestDTO.builder().productId(uuid).build();
		CartItem converted = cartItemMapper.toCartItem(dto);
		assertNotNull(converted);
		assertEquals(dto.getProductId(), converted.getProductId());
	}

	@Test
	void toCartItems() {
		UUID uuid = UUID.randomUUID();
		CartItemRequestDTO cartItemRequestDTO = CartItemRequestDTO.builder().productId(uuid).build();
		CartItemRequestCollectionDTO dto = CartItemRequestCollectionDTO.builder().cartItems(List.of(cartItemRequestDTO)).build();
		List<CartItem> converted = cartItemMapper.toCartItems(dto);
		assertNotNull(converted);
		assertEquals(cartItemRequestDTO.getProductId(), converted.get(0).getProductId());
	}
}