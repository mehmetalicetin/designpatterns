package com.i2i.ssa.api.order.mapper;

import com.i2i.ssa.api.order.dto.order.OrderRequestDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import com.i2i.ssa.api.order.dto.orderitem.OrderItemRequestDTO;
import com.i2i.ssa.api.order.model.Order;
import com.i2i.ssa.api.order.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderMapper {

	private final OrderItemMapper orderItemMapper;

	public OrderMapper(OrderItemMapper orderItemMapper) {
		this.orderItemMapper = orderItemMapper;
	}

	public Order toOrder(OrderRequestDTO dto) {
		return Order.builder()
				.customerAddress(dto.getCustomerAddress())
				.uniqueProducts(dto.getUniqueProducts())
				.totalDiscount(dto.getTotalDiscount())
				.totalPrice(dto.getTotalPrice())
				.customerId(dto.getCustomerId())
				.customerName(dto.getCustomerName())
				.items(getOrderItems(dto.getItems()))
				.build();
	}

	private List<OrderItem> getOrderItems(List<OrderItemRequestDTO> items) {
		if (Objects.isNull(items)) {
			return List.of();
		}
		List<OrderItem> orderItems = new ArrayList<>();
		for (OrderItemRequestDTO item : items) {
			OrderItem orderItem = orderItemMapper.toOrderItem(item);
			orderItems.add(orderItem);
		}
		return orderItems;
	}

	public OrderResponseDTO toResponseDTO(Order order) {
		if (Objects.isNull(order)) {
			throw new RuntimeException("Order cannot found!");
		}

		return OrderResponseDTO.builder()
				.orderId(order.getId())
				.customerId(order.getCustomerId())
				.customerName(order.getCustomerName())
				.totalPrice(order.getTotalPrice())
				.totalProducts(order.getTotalProducts())
				.totalDiscount(order.getTotalDiscount())
				.items(orderItemMapper.toResponseDTOs(order.getItems()))
				.build();

	}

	public OrderResponseCollectionDTO toResponseDTOs(List<Order> orders) {
		if (Objects.isNull(orders)) {
			throw new RuntimeException("Orders cannot found!");
		}

		return OrderResponseCollectionDTO.builder()
				.orders(getListOrderResponse(orders))
				.build();

	}

	private List<OrderResponseDTO> getListOrderResponse(List<Order> orders) {
		List<OrderResponseDTO> orderResponseDTOS = new ArrayList<>();
		for (Order order : orders) {
			orderResponseDTOS.add(toResponseDTO(order));
		}
		return orderResponseDTOS;
	}
}
