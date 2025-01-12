package com.i2i.ssa.api.inventory.controller;

import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(value = "/api/v1/product")
public interface ProductApi {

	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Success",
				content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
						schema = @Schema(implementation = ProductResponseDTO.class)) }),
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
@Operation(summary = "This operation creates customer")
ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO);


@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = ProductResponseCollectionDTO.class)) }),
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
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "This operation returns details of products")
	ResponseEntity<ProductResponseCollectionDTO> getProducts();



		@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
							schema = @Schema(implementation = ProductResponseDTO.class)) }),
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
	@Operation(summary = "This operation returns details of product with given id")
	ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id);



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
@PostMapping(value = "/{id}/use/{quantity}", produces = MediaType.APPLICATION_JSON_VALUE)
@Operation(summary = "This operation removes given quantity from the stock quantity of the product with given id")
ResponseEntity<Void> decrementQuantity(@PathVariable("id") UUID id, @PathVariable("quantity") Integer quantity);
}
