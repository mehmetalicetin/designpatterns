package com.i2i.ssa.api.order.controller;

import com.i2i.ssa.api.order.dto.order.OrderRequestDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/order")
public interface OrderApi {
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = OrderResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "401", description = "Unauthorized",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "403", description = "Forbidden",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "405", description = "Method Not allowed",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "409", description = "Conflict",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }) })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retrieves the details of an order by its unique ID.")
	ResponseEntity<OrderResponseDTO> findOrderById(@PathVariable("id") UUID id);


	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = OrderResponseCollectionDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "401", description = "Unauthorized",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "403", description = "Forbidden",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "405", description = "Method Not allowed",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "409", description = "Conflict",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }) })
	@GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retrieves all orders associated with the specified customer ID.")
	ResponseEntity<OrderResponseCollectionDTO> getCustomerOrders(@PathVariable("customerId") UUID customerId);


	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = OrderResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "401", description = "Unauthorized",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "403", description = "Forbidden",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "405", description = "Method Not allowed",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "409", description = "Conflict",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }),
			@ApiResponse(responseCode = "500", description = "Internal Server Error",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = Error.class)) }) })
	@PostMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Creates an order from the specified cart, deletes the cart upon successful order creation, and returns the details of the newly created order.")
	ResponseEntity<OrderResponseDTO> createOrderFromCart(@RequestBody OrderRequestDTO orderRequestDTO, @PathVariable("customerId") UUID customerId);
}
