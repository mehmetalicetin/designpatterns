package com.i2i.ssa.api.customer.mapper;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.customer.model.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

	public CustomerResponseDTO toResponseCustomerDTO(@NotNull Customer source) {
		return CustomerResponseDTO.builder()
				.id(source.getId())
				.name(source.getName())
				.address(source.getAddress())
				.createDate(source.getCreateDate())
				.build();
	}

	public Customer toCustomer(@NotNull CustomerRequestDTO source) {
		return Customer.builder()
				.name(source.getName())
				.address(source.getAddress())
				.build();
	}
}
