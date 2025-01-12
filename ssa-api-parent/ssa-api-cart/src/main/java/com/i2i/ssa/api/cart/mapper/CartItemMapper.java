package com.i2i.ssa.api.cart.mapper;

import com.i2i.dto.cartItem.CartItemRequestCollectionDTO;
import com.i2i.dto.cartItem.CartItemRequestDTO;
import com.i2i.ssa.api.cart.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CartItemMapper {

	public CartItem toCartItem(CartItemRequestDTO responseCartItemDto) {
		return CartItem.builder()
				.productId(responseCartItemDto.getProductId())
				.quantity(responseCartItemDto.getQuantity())
				.build();
	}

	public List<CartItem> toCartItems(CartItemRequestCollectionDTO cartItemRequestCollectionDTO) {
		if (Objects.isNull(cartItemRequestCollectionDTO ) || Objects.isNull(cartItemRequestCollectionDTO.getCartItems())) {
			return List.of();
		}
		return cartItemRequestCollectionDTO.getCartItems().stream().map(this::toCartItem).collect(Collectors.toList());
	}
}
