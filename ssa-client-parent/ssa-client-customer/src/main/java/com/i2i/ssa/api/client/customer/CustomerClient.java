package com.i2i.ssa.api.client.customer;



import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "customer-service", path = "/api/v1/customer")
public interface CustomerClient {

    @GetMapping("/{id}")
	ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable("id") UUID id);

    @PostMapping("/customer")
    ResponseEntity<CustomerResponseDTO> create(@RequestBody CustomerRequestDTO requestCustomerDto);
}