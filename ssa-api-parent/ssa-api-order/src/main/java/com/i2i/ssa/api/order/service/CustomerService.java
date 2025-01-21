package com.i2i.ssa.api.order.service;

import com.i2i.dto.CustomerResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class CustomerService {
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	private final RestTemplate restTemplate;

	public CustomerService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@CircuitBreaker(name = "order-service", fallbackMethod = "fallBackGetCustomer")
	public CustomerResponseDTO getCustomer(UUID customerId) {
		return restTemplate.getForObject("http://customer-service/api/v1/customer/" + customerId, CustomerResponseDTO.class);
	}

	public CustomerResponseDTO fallBackGetCustomer(UUID customerId, Throwable t) {
		log.error("Check customer failed {}", customerId);
		return CustomerResponseDTO.builder().build();
	}
}
