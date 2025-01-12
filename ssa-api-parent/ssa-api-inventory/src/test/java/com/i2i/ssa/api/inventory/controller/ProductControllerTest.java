package com.i2i.ssa.api.inventory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import com.i2i.ssa.api.inventory.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	static final String BASE_URL = "http://localhost:8090/api/v1/product";

	@InjectMocks
	private ProductController controller;

	@Mock
	private ProductService service;


	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.defaultRequest(get("").accept(MediaType.APPLICATION_JSON))
				.build();

	}


	@Test
	void getProducts() throws Exception {
		UUID uuid = UUID.randomUUID();
		ProductResponseCollectionDTO responseCollectionProductDto = ProductResponseCollectionDTO.builder()
				.products(List.of(ProductResponseDTO.builder().id(uuid).build()))
				.build();

		when(service.getProducts()).thenReturn(responseCollectionProductDto);

		ResultActions resultActions = mockMvc.perform(get(BASE_URL, uuid));
		resultActions.andExpect(status().isOk());
	}

	@Test
	void getProductById() throws Exception {
		String uri = BASE_URL +"/{id}";
		UUID uuid = UUID.randomUUID();
		ProductResponseDTO responseDto = ProductResponseDTO.builder()
				.id(uuid)
				.build();

		when(service.getProductById(any())).thenReturn(responseDto);

		ResultActions resultActions = mockMvc.perform(get(uri, uuid));
		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void decrementQuantity() throws Exception {
		String uri = BASE_URL +"/{id}/use/{quantity}";
		UUID uuid = UUID.randomUUID();
		Integer quantity = 20;

		doNothing().when(service).decrementQuantity(any(UUID.class), anyInt());

		ResultActions resultActions = mockMvc.perform(post(uri, uuid, quantity));
		resultActions.andExpect(status().isNoContent());
	}

	@Test
	void create() throws Exception {
		ProductRequestDTO requestDto = ProductRequestDTO.builder().build();

		when(service.create(any(ProductRequestDTO.class)))
				.thenReturn(ProductResponseDTO.builder().name("Ali").build());

		String json = getJson(requestDto);
		var resultActions = mockMvc.perform(post(BASE_URL).content(json).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	private static <T> String getJson(T t) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(t);
	}
}