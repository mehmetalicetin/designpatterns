package com.i2i.ssa.api.order.mapper;

import com.i2i.ssa.api.order.dto.orderitem.OrderItemRequestDTO;
import com.i2i.ssa.api.order.dto.orderitem.OrderItemResponseDTO;
import com.i2i.ssa.api.order.model.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

class OrderItemMapperTest {
	private OrderItemMapper mapper;
	@BeforeEach
	void setUp() {
		mapper = new OrderItemMapper();
	}
	@Test
	void toOrderItem() {
		UUID id = UUID.randomUUID();
		OrderItemRequestDTO dto = OrderItemRequestDTO.builder().productId(id).build();
		OrderItem orderItem = mapper.toOrderItem(dto);
		Assertions.assertNotNull(orderItem);
		Assertions.assertEquals(id, orderItem.getProductId());
	}

	@Test
	void toResponseDTO() {
		UUID id = UUID.randomUUID();
		OrderItem dto = OrderItem.builder().productId(id).build();
		OrderItemResponseDTO orderItemResponseDTO = mapper.toResponseDTO(dto);
		Assertions.assertNotNull(orderItemResponseDTO);
		Assertions.assertEquals(id, orderItemResponseDTO.getProductId());
	}

	@Test
	void toResponseDTOs() {
		UUID id = UUID.randomUUID();
		List<OrderItemResponseDTO> responseDTOs = mapper.toResponseDTOs(List.of(OrderItem.builder().productId(id).build()));
		Assertions.assertNotNull(responseDTOs);
		Assertions.assertEquals(1, responseDTOs.size());
	}
}