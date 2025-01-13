package com.i2i.ssa.api.cart.controller;

import com.i2i.dto.cart.CartRequestDTO;
import com.i2i.dto.cart.CartResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/cart")
public interface CartApi {
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = UUID.class)) }),
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
	@Operation(summary = "This operation creates cart")
	ResponseEntity<UUID> create(@RequestBody CartRequestDTO cartRequestDTO);

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = CartResponseDTO.class)) }),
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
	@Operation(summary = "This operation returns cart with given id")
	ResponseEntity<CartResponseDTO> getCartById(@PathVariable("id") UUID id);


	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema()) }),
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
	@PostMapping(value = "/{id}/add/{productId}/{quantity}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This operation adds the product with given id with given quantity to the cart with given id")
	ResponseEntity<Void> addProductWithGivenIdAndGivenQuantityToCart(@PathVariable("id") UUID id, @PathVariable("productId") UUID productId,
			@PathVariable("quantity") Integer quantity);


	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = UUID.class)) }),
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
	@PostMapping(value = "/{id}/remove/{productId}/{quantity}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This operation removes the product with given id with given quantity to the cart with given id")
	ResponseEntity<Void> removeProductWithGivenIdAndGivenQuantityToCart(@PathVariable("id") UUID id, @PathVariable("productId") UUID productId,
			@PathVariable("quantity") Integer quantity);


	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = CartResponseDTO.class)) }),
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
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This operation deletes the cart with given id")
	ResponseEntity<Void> deleteCartById(@PathVariable("id") UUID id);
}
