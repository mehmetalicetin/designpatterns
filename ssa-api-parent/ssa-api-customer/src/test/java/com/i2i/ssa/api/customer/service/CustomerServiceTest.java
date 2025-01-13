package com.i2i.ssa.api.customer.service;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.customer.mapper.CustomerMapper;
import com.i2i.ssa.api.customer.model.Customer;
import com.i2i.ssa.api.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	CustomerRepository repository;

	@Mock
	CustomerMapper converter;

	@InjectMocks
	CustomerService service;

	MockMvc mockMvc;

	@Mock
	CustomerRequestDTO requestDto;

	@Mock
	Customer customer;

	@Mock
	CustomerResponseDTO responseDto;

	@Mock
	UUID uuid;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}


	@Test
	void create() {
		when(repository.save(any(Customer.class))).thenReturn(customer);
		when(converter.toCustomer(any(CustomerRequestDTO.class))).thenReturn(customer);
		when(converter.toResponseCustomerDTO(any(Customer.class))).thenReturn(responseDto);
		service.create(requestDto);

		verify(repository, times(1)).save(any());
	}

	@Test
	void getCustomerById() {
		Optional<Customer> customerOptional = Optional.of(new Customer());
		when(repository.findById(any())).thenReturn(customerOptional);
		service.getCustomerById(uuid);

		verify(repository, times(1)).findById(any());

	}
}