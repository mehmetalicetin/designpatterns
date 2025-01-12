package com.i2i.ssa.api.cart.service;

import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.ssa.api.cart.mapper.CartMapper;
import com.i2i.ssa.api.cart.model.Cart;
import com.i2i.ssa.api.cart.repository.CartRepository;
import com.i2i.ssa.api.core.service.BaseService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CartService extends BaseService<Cart> {
	private static final Logger log = LoggerFactory.getLogger(CartService.class);

	private final CartItemService cartItemService;
	private final CartMapper      cartMapper;

	public CartService(CartRepository repository, CartItemService cartItemService, CartMapper cartMapper) {
		super(repository);
		this.cartItemService = cartItemService;
		this.cartMapper = cartMapper;
	}

	public UUID create(CartRequestDTO cartRequestDTO) {
		Cart cart = cartMapper.toCart(cartRequestDTO);
		Cart savedCart = save(cart);
		log.info("[create()]...  completed successfully.");
		return savedCart.getId();
	}

	public CartResponseDTO getCartById(UUID id) {
		return cartMapper.toCartResponseDTO(getCart(id));
	}

	private @NotNull Cart getCart(UUID id) {
		Optional<Cart> optionalCart = findById(id);
		if (optionalCart.isPresent()) {
			return optionalCart.get();
		}
		log.error("Cart not found");
		throw new RuntimeException("Cart not found");
	}

	public void addProductWithGivenIdAndGivenQuantityToCart(UUID id, UUID productId, Integer quantity) {
		Cart cart = getCart(id);
		cartItemService.addProductWithGivenIdAndGivenQuantityToCart(cart, productId, quantity);
		log.info("[addProductWithGivenIdAndGivenQuantityToCart()]...  completed successfully.");
	}

	public void removeProductWithGivenIdAndGivenQuantityToCart(UUID id, UUID productId, Integer quantity) {
		Cart cart = getCart(id);
		cartItemService.removeProductWithGivenIdAndGivenQuantityToCart(cart, productId, quantity);
		log.info("[removeProductWithGivenIdAndGivenQuantityToCart()]...  completed successfully.");

	}

	public void deleteCartById(UUID id) {
		Cart cart = getCart(id);
		delete(cart);
		log.info("[deleteCartById()]...  completed successfully.");
	}
}
