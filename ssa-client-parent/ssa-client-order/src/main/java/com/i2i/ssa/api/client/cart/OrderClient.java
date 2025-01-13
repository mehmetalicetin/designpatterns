package com.i2i.ssa.api.client.cart;

import com.i2i.dto.order.OrderResponseCollectionDTO;
import com.i2i.dto.order.OrderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "order-service", url = "${order.service.url}")
public interface OrderClient {

    @GetMapping("/api/v1/order/{id}")
	ResponseEntity<OrderResponseDTO> findOrderById(@PathVariable("id") UUID id);

    @GetMapping(value = "/api/v1/order/customer/{customerId}")
    ResponseEntity<OrderResponseCollectionDTO> getCustomerOrders(@PathVariable("customerId") UUID customerId);

    @PostMapping(value = "/api/v1/order/{cartId}")
    ResponseEntity<OrderResponseDTO> createOrderFromCart(@PathVariable("cartId") UUID cartId);
}