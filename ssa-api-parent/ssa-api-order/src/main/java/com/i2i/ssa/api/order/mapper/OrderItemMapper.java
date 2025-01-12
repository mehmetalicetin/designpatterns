package com.i2i.ssa.api.order.mapper;

import com.i2i.ssa.api.order.dto.orderitem.OrderItemRequestDTO;
import com.i2i.ssa.api.order.dto.orderitem.OrderItemResponseDTO;
import com.i2i.ssa.api.order.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderItemMapper {

	public OrderItem toOrderItem(OrderItemRequestDTO dto) {
		return OrderItem.builder()
				.totalPrice(dto.getTotalPrice())
				.unitPrice(dto.getUnitPrice())
				.totalDiscount(dto.getTotalDiscount())
				.unitPrice(dto.getUnitPrice())
				.unitDiscount(dto.getUnitDiscount())
				.productName(dto.getProductName())
				.quantity(dto.getQuantity())
				.productId(dto.getProductId())
				.build();
	}

	public OrderItemResponseDTO toResponseDTO(OrderItem orderItem) {
		if (orderItem == null) {
			throw new RuntimeException("orderItem not found!");
		}

		return OrderItemResponseDTO.builder()
				.totalDiscount(orderItem.getTotalDiscount())
				.productId(orderItem.getProductId())
				.productName(orderItem.getProductName())
				.unitDiscount(orderItem.getUnitDiscount())
				.quantity(orderItem.getQuantity())
				.build();
	}

	public List<OrderItemResponseDTO> toResponseDTOs(List<OrderItem> orderItems) {
		if (Objects.isNull(orderItems)) {
			return List.of();
		}

		List<OrderItemResponseDTO> orderItemResponseDTOS = new ArrayList<>();
		for (OrderItem orderItem : orderItems) {
			OrderItemResponseDTO responseDTO = toResponseDTO(orderItem);
			orderItemResponseDTOS.add(responseDTO);
		}
		return orderItemResponseDTOS;
	}

}