package com.i2i.ssa.api.order.service;

import com.i2i.dto.CustomerResponseDTO;
import com.i2i.dto.cart.CartResponseDTO;
import com.i2i.ssa.api.client.cart.CartClient;
import com.i2i.ssa.api.core.service.BaseService;
import com.i2i.ssa.api.order.dto.order.OrderRequestDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import com.i2i.ssa.api.order.mapper.OrderMapper;
import com.i2i.ssa.api.order.model.Order;
import com.i2i.ssa.api.order.repository.OrderRepository;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class OrderService extends BaseService<Order> {
	private final  OrderRepository repository;
	private  final OrderMapper    orderMapper;
	private final CartClient      cartClient;
	private final DiscoveryClient customerClient;

	public OrderService(OrderRepository repository, OrderMapper orderMapper, CartClient cartClient, DiscoveryClient customerClient) {
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

	public OrderResponseDTO createOrderFromCustomer(OrderRequestDTO orderRequestDTO, UUID customerId) {
		checkCustomerExist(customerId);

		Order order = orderMapper.toOrder(orderRequestDTO);
		Order saved = save(order);

		deleteCart(customerId);


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
		// Get available instances of the customer service
		List<ServiceInstance> customerClientInstances = customerClient.getInstances("customer-service");
		if (customerClientInstances.isEmpty()) {
			throw new RuntimeException("No instances of 'customer-service' are available.");
		}

		// Select an instance using a load-balancing strategy
		ServiceInstance selectedInstance = customerClientInstances.get(new Random().nextInt(customerClientInstances.size()));

		// Build the service URL
		String serviceUrl = String.format("http://%s:%d/api/v1/customer/%s",
				selectedInstance.getHost(),
				selectedInstance.getPort(),
				customerId.toString());

		// Perform the API call
		RestTemplate restTemplate = new RestTemplate(); // Or use your configured RestTemplate bean
		ResponseEntity<CustomerResponseDTO> response;
		try {
			response = restTemplate.getForEntity(serviceUrl, CustomerResponseDTO.class);
		} catch (Exception ex) {
			throw new RuntimeException("Error while contacting 'customer-service': " + ex.getMessage(), ex);
		}

		// Check response status
		if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
			throw new RuntimeException("Customer not found");
		}




//		// Get available instances of the customer service
//		List<ServiceInstance> customerClientInstances = customerClient.getInstances("customer-service");
//		if (customerClientInstances.isEmpty()) {
//			throw new RuntimeException("No instances of 'customer-service' are available.");
//		}
////		customerClient.getInstances("customer-service");
////		ResponseEntity<CustomerResponseDTO> customer = customerClient.getCustomerById(customerId);
////		if (!customer.getStatusCode().is2xxSuccessful())
////			throw new RuntimeException("Customer not found");
	}

	public OrderResponseCollectionDTO findOrdersByCustomerId(UUID customerId) {
		checkCustomerExist(customerId);
		List<Order> orders = repository.findOrdersByCustomerId(customerId);
		return orderMapper.toResponseDTOs(orders);
	}
}
