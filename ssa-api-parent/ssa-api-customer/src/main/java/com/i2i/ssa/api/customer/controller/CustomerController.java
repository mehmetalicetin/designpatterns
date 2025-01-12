package com.i2i.ssa.api.customer.controller;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.core.controller.BaseController;
import com.i2i.ssa.api.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CustomerController extends BaseController<CustomerService> implements CustomerApi {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super(customerService);
		this.customerService = customerService;
	}

	@Override
	public ResponseEntity<CustomerResponseDTO> create(CustomerRequestDTO customerRequestDTO) {
		return ResponseEntity.ok(customerService.create(customerRequestDTO));
	}

	@Override
	public ResponseEntity<CustomerResponseDTO> getCustomerById(UUID id) {
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
}
