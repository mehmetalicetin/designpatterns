package com.i2i.ssa.api.cart.service;

import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.ssa.api.cart.mapper.CartMapper;
import com.i2i.ssa.api.cart.model.Cart;
import com.i2i.ssa.api.cart.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
	@InjectMocks
	private CartService service;

	@Mock
	CartItemService cartItemService;

	@Mock
	CartMapper converter;

	@Mock
	CartRepository cartRepository;

	@Mock
	CartRequestDTO cartRequestDTO;

	@Mock
	CartResponseDTO cartResponseDTO;

	@Mock
	UUID uuid;

	@Mock
	Cart cart;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}



	@Test
	void create() {
		when(cartRepository.save(any(Cart.class))).thenReturn(cart);
		when(converter.toCart(cartRequestDTO)).thenReturn(cart);
		service.create(cartRequestDTO);
	}

	@Test
	void getCartById() {
		when(cartRepository.findById(uuid)).thenReturn(Optional.ofNullable(cart));
		service.getCartById(uuid);
	}

	@Test
	void addProductWithGivenIdAndGivenQuantityToCart() {
		when(cartRepository.findById(uuid)).thenReturn(Optional.ofNullable(cart));
		service.addProductWithGivenIdAndGivenQuantityToCart(uuid, uuid, 20);
	}

	@Test
	void removeProductWithGivenIdAndGivenQuantityToCart() {
		when(cartRepository.findById(uuid)).thenReturn(Optional.ofNullable(cart));
		service.removeProductWithGivenIdAndGivenQuantityToCart(uuid, uuid, 20);
	}

	@Test
	void deleteCartById() {
		when(cartRepository.findById(uuid)).thenReturn(Optional.ofNullable(cart));
		service.deleteCartById(uuid);
	}
}