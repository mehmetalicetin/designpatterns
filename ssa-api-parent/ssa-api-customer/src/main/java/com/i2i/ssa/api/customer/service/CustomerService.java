package com.i2i.ssa.api.customer.service;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.core.service.BaseService;
import com.i2i.ssa.api.customer.mapper.CustomerMapper;
import com.i2i.ssa.api.customer.model.Customer;
import com.i2i.ssa.api.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<Customer> {
	private static final Logger         log = LoggerFactory.getLogger(CustomerService.class);
	private final        CustomerMapper customerConvert;

	public CustomerService(CustomerRepository customerRepository, CustomerMapper customerConvert) {
		super(customerRepository);
		this.customerConvert = customerConvert;
	}


	public CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO) {
		log.info("create customer : {}", customerRequestDTO);
		Customer customer = customerConvert.toCustomer(customerRequestDTO);
		return customerConvert.toResponseCustomerDTO(save(customer));
	}

	public CustomerResponseDTO getCustomerById(UUID id) {
		log.info("get customer by id : {}", id);
		Optional<Customer> customer = findById(id);
		if (customer.isPresent()) {
			return customerConvert.toResponseCustomerDTO(customer.get());
		}
		throw new RuntimeErrorException(new Error(), "Cannot find customer by id");
	}
}
