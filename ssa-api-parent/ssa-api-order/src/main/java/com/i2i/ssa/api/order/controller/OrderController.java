package com.i2i.ssa.api.order.controller;

import com.i2i.ssa.api.core.controller.BaseController;
import com.i2i.ssa.api.order.dto.order.OrderRequestDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import com.i2i.ssa.api.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController extends BaseController<OrderService> implements OrderApi{
	protected OrderController(OrderService service) {
		super(service);
	}

	@Override
	public ResponseEntity<OrderResponseDTO> findOrderById(UUID id) {
		return ResponseEntity.ok(service.findOrderById(id));
	}

	@Override
	public ResponseEntity<OrderResponseCollectionDTO> getCustomerOrders(UUID customerId) {
		return ResponseEntity.ok(service.findOrdersByCustomerId(customerId));
	}

	@Override
	public ResponseEntity<OrderResponseDTO> createOrderFromCart(OrderRequestDTO orderRequestDTO, UUID customerId) {
		return ResponseEntity.ok(service.createOrderFromCustomer(orderRequestDTO, customerId));
	}
}
