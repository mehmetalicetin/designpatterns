package com.i2i.ssa.api.cart.mapper;

import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.dto.cartItem.CartItemRequestCollectionDTO;
import com.i2i.dto.cartItem.CartItemRequestDTO;
import com.i2i.ssa.api.cart.model.Cart;
import com.i2i.ssa.api.cart.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
	private final CartItemMapper cartItemMapper;

	public CartMapper(CartItemMapper cartItemMapper) {
		this.cartItemMapper = cartItemMapper;
	}

	public Cart toCart(CartRequestDTO cartRequestDTO) {
		return Cart.builder()
				.customerId(cartRequestDTO.getCustomerId())
				.items(cartItemMapper.toCartItems(cartRequestDTO.getCartItemRequestCollectionDTO()))
				.build();
	}

	public CartResponseDTO toCartResponseDTO(Cart cart) {
		return CartResponseDTO.builder()
				.customerId(cart.getCustomerId())
				.createDate(cart.getCreateDate())
				.lastUpdate(cart.getLastUpdate())
				.cartItemRequestCollectionDTO(getCollectionCartItemDTO(cart))
				.build();
	}

	private CartItemRequestCollectionDTO getCollectionCartItemDTO(Cart cart) {
		return CartItemRequestCollectionDTO.builder()
				.cartItems(getCartItemRequestDTOs(cart.getItems()))
				.build();
	}

	private List<CartItemRequestDTO> getCartItemRequestDTOs(List<CartItem> items) {
		if (items == null) {
			return List.of();
		}
		return items.stream().map(this::toCartItemRequestDTO).collect(Collectors.toList());
	}

	private CartItemRequestDTO toCartItemRequestDTO(CartItem cartItem) {
		return CartItemRequestDTO.builder()
				.productId(cartItem.getProductId())
				.quantity(cartItem.getQuantity())
				.build();
	}
}
