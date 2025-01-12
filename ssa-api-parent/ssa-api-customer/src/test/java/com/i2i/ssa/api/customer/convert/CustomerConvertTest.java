package com.i2i.ssa.api.customer.convert;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.customer.mapper.CustomerMapper;
import com.i2i.ssa.api.customer.model.Customer;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerConvertTest {
	@Test
	void convertDto() {
		CustomerMapper customerConvert = new CustomerMapper();
		CustomerRequestDTO customerRequestDTO = CustomerRequestDTO.builder()
				.name("Ali")
				.address("Istanbul")
				.build();
		Customer converted = customerConvert.toCustomer(customerRequestDTO);
		assertNotNull(converted);
		assertEquals(customerRequestDTO.getName(), converted.getName());
	}

	@Test
	void convertDataModel() {
		CustomerMapper customerConvert = new CustomerMapper();
		UUID uuid = UUID.randomUUID();
		Customer customer = Customer.builder()
				.id(uuid)
				.name("Ali")
				.address("Istanbul")
				.build();
		CustomerResponseDTO converted = customerConvert.toResponseCustomerDTO(customer);
		assertNotNull(converted);
		assertEquals(uuid, converted.getId());
	}
}