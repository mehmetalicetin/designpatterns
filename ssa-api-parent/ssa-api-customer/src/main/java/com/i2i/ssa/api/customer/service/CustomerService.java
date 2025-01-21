package com.i2i.ssa.api.customer.service;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.core.service.BaseService;
import com.i2i.ssa.api.customer.mapper.CustomerMapper;
import com.i2i.ssa.api.customer.model.Customer;
import com.i2i.ssa.api.customer.repository.CustomerRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

//	public CustomerResponseDTO getCustomerById(UUID id) {
//		log.info("get customer by id : {}", id);
//		Optional<Customer> customer = findById(id);
//		if (customer.isPresent()) {
//			return customerConvert.toResponseCustomerDTO(customer.get());
//		}
//		throw new RuntimeException("Cannot find customer by id");
//	}

	//@CircuitBreaker(name = "customer-service", fallbackMethod = "fallBackCustomerById")
	public CustomerResponseDTO getCustomerById(UUID id) {
		log.info("get customer by id : {}", id);
		Optional<Customer> customer = findById(id);
		if (customer.isPresent()) {
			return customerConvert.toResponseCustomerDTO(customer.get());
		}
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
		throw new RuntimeErrorException(new Error(), "Cannot find customer by id");
	}

	public CustomerResponseDTO fallBackCustomerById(UUID id, Throwable throwable) {
		log.info("fallBack customer by id : {}", id);
		throwable.printStackTrace();
		return CustomerResponseDTO.builder().id(id).build();
	}


}
