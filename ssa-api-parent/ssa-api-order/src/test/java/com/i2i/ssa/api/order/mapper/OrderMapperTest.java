package com.i2i.ssa.api.order.mapper;

import com.i2i.ssa.api.order.dto.order.OrderRequestDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import com.i2i.ssa.api.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderMapperTest {
	OrderMapper mapper;
	@BeforeEach
	void setUp() {
		OrderItemMapper orderItemMapper = new OrderItemMapper();
		mapper = new OrderMapper(orderItemMapper);
	}
	@Test
	void toOrder() {
		UUID customerId = UUID.randomUUID();
		OrderRequestDTO orderRequestDTO = OrderRequestDTO.builder().customerId(customerId).build();
		Order order = mapper.toOrder(orderRequestDTO);
		assertNotNull(order);
		assertEquals(customerId, order.getCustomerId());
	}

	@Test
	void toResponseDTO() {
		UUID customerId = UUID.randomUUID();
		Order order = Order.builder().customerId(customerId).build();
		OrderResponseDTO responseDTO = mapper.toResponseDTO(order);
		assertNotNull(responseDTO);
		assertEquals(customerId, responseDTO.getCustomerId());
	}

	@Test
	void toResponseDTOs() {
		UUID customerId = UUID.randomUUID();
		List<Order> orders = List.of(Order.builder().customerId(customerId).build());
		OrderResponseCollectionDTO responseDTOs = mapper.toResponseDTOs(orders);
		assertNotNull(responseDTOs);
		assertEquals(orders.size(), responseDTOs.getOrders().size());
	}
}