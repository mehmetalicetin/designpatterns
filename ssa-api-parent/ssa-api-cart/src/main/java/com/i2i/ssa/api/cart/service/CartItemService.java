package com.i2i.ssa.api.cart.service;

import com.i2i.ssa.api.cart.model.Cart;
import com.i2i.ssa.api.cart.model.CartItem;
import com.i2i.ssa.api.cart.repository.CartItemRepository;
import com.i2i.ssa.api.core.service.BaseService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartItemService extends BaseService<CartItem> {
	private final CartItemRepository cartItemRepository;

	public CartItemService(CartItemRepository cartItemRepository) {
		super(cartItemRepository);
		this.cartItemRepository = cartItemRepository;
	}

	public void addProductWithGivenIdAndGivenQuantityToCart(@NotNull Cart cart, UUID productId, Integer quantity) {
		CartItem cartItem = CartItem.builder()
				.productId(productId)
				.quantity(quantity)
				.build();

		cart.addCartItem(cartItem);

		save(cartItem);
	}

	public void removeProductWithGivenIdAndGivenQuantityToCart(@NotNull Cart cart, UUID productId, Integer quantity) {
		cartItemRepository.removeProductWithGivenIdAndGivenQuantity(cart.getId(), productId, quantity);
	}

}
