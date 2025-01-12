package com.i2i.ssa.api.customer.controller;

import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(value = "/api/v1/customer")
public interface CustomerApi {
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = CustomerResponseDTO.class)) }),
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
	@PostMapping(value = "",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create customer")
	ResponseEntity<CustomerResponseDTO> create(@RequestBody CustomerRequestDTO customerRequestDTO);



	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = CustomerResponseDTO.class)) }),
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
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Return details of customer with given id")
	ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable("id") UUID id);
}
