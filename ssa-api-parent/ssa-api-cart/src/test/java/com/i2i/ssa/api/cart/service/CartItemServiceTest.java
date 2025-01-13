package com.i2i.ssa.api.cart.service;

import com.i2i.ssa.api.cart.model.Cart;
import com.i2i.ssa.api.cart.model.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class CartItemServiceTest {

	@InjectMocks
	private CartItemService service;
	@Mock
	UUID uuid;

	@Mock
	private CartItem cartItem;

	@Mock
	private Cart cart;

	MockMvc mockMvc;


	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}


	@Test
	void addProductWithGivenIdAndGivenQuantityToCart() {
		Cart cart = Mockito.mock(Cart.class);
		service.addProductWithGivenIdAndGivenQuantityToCart(cart, uuid, anyInt());
	}

	@Test
	void removeProductWithGivenIdAndGivenQuantityToCart() {
		service.removeProductWithGivenIdAndGivenQuantityToCart(cart, uuid, 20);
	}
}