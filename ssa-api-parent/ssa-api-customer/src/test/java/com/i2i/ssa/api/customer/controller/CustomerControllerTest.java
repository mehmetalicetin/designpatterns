package com.i2i.ssa.api.customer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.i2i.dto.CustomerRequestDTO;
import com.i2i.dto.CustomerResponseDTO;
import com.i2i.ssa.api.customer.service.CustomerService;
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

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

	static final String BASE_URL = "http://localhost:8085/api/v1/customer";

	@Mock
	CustomerService service;

	@InjectMocks
	CustomerController controller;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.defaultRequest(get("").accept(MediaType.APPLICATION_JSON))
				.build();

	}

	@Test
	void create() throws Exception {
		String uri = BASE_URL;
		CustomerRequestDTO requestDto = CustomerRequestDTO.builder().build();

		when(service.create(any(CustomerRequestDTO.class)))
				.thenReturn(CustomerResponseDTO.builder().name("Ali").build());

		String json = getJson(requestDto);
		var resultActions = mockMvc.perform(post(uri).content(json).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void getCustomerById() throws Exception {
		String uri = BASE_URL +"/{id}";
		UUID uuid = UUID.randomUUID();
		CustomerResponseDTO responseDto = CustomerResponseDTO.builder()
				.id(uuid)
				.build();

		when(service.getCustomerById(any())).thenReturn(responseDto);

		ResultActions resultActions = mockMvc.perform(get(uri, uuid));
		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(uuid.toString()));
	}

	private static <T> String getJson(T t) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(t);
	}
}