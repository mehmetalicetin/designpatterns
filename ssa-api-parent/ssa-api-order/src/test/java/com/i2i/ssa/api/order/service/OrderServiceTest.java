package com.i2i.ssa.api.order.service;

import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.client.customer.CustomerClient;
import com.i2i.ssa.api.order.model.Order;
import com.i2i.ssa.api.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private CustomerClient customerClient;

	@Mock
	Order order;

	@Mock
	UUID uuid;

	@Mock
	ResponseEntity<CustomerResponseDTO> responseCustomer;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void findOrderById() {
		when(orderRepository.findById(uuid)).thenReturn(Optional.ofNullable(order));
		orderService.findOrderById(uuid);
	}

	@Test
	void createOrderFromCustomer() {

	}

	@Test
	void findOrdersByCustomerId() {
		when(customerClient.getCustomerById(uuid)).thenReturn(responseCustomer);
		when(responseCustomer.getStatusCode()).thenReturn(HttpStatus.OK);
		orderService.findOrdersByCustomerId(uuid);
	}
}