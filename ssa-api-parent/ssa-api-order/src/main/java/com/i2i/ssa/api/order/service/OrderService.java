package com.i2i.ssa.api.order.service;

import com.i2i.dto.CustomerResponseDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.ssa.api.client.cart.CartClient;
import com.i2i.ssa.api.client.customer.CustomerClient;
import com.i2i.ssa.api.core.service.BaseService;
import com.i2i.ssa.api.order.dto.order.OrderRequestDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import com.i2i.ssa.api.order.mapper.OrderMapper;
import com.i2i.ssa.api.order.model.Order;
import com.i2i.ssa.api.order.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService extends BaseService<Order> {
	private final  OrderRepository repository;
	private  final OrderMapper    orderMapper;
	private final CartClient     cartClient;
	private final CustomerClient customerClient;

	public OrderService(OrderRepository repository, OrderMapper orderMapper, CartClient cartClient, CustomerClient customerClient) {
		super(repository);
		this.orderMapper = orderMapper;
		this.repository= repository;
		this.cartClient = cartClient;
		this.customerClient = customerClient;
	}

	public OrderResponseDTO findOrderById(UUID id) {
		Optional<Order> optionalOrder = repository.findById(id);
		if (optionalOrder.isEmpty()) {
			throw new RuntimeException("Order not found");
		}
		Order order = optionalOrder.get();
		return orderMapper.toResponseDTO(order);
	}

	public OrderResponseDTO createOrderFromCustomer(OrderRequestDTO orderRequestDTO, UUID cartId) {
		checkCustomerExist(orderRequestDTO.getCustomerId());

		Order order = orderMapper.toOrder(orderRequestDTO);
		Order saved = save(order);

		deleteCart(cartId);


		return orderMapper.toResponseDTO(saved);
	}
	private void deleteCart(UUID cartId) {
		checkCartExist(cartId);
		cartClient.deleteCartById(cartId);
	}

	private void checkCartExist(UUID cartId) {
		ResponseEntity<CartResponseDTO> cart = cartClient.getCartById(cartId);
		if (!cart.getStatusCode().is2xxSuccessful()) {
			throw  new RuntimeException("Cart cannot found");
		}
	}


	private void checkCustomerExist(UUID customerId) {
		ResponseEntity<CustomerResponseDTO> customer = customerClient.getCustomerById(customerId);
		if (!customer.getStatusCode().is2xxSuccessful())
			throw new RuntimeException("Customer not found");
	}

	public OrderResponseCollectionDTO findOrdersByCustomerId(UUID customerId) {
		checkCustomerExist(customerId);
		List<Order> orders = repository.findOrdersByCustomerId(customerId);
		return orderMapper.toResponseDTOs(orders);
	}
}
