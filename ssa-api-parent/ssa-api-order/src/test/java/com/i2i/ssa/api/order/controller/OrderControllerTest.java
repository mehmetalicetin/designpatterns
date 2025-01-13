package com.i2i.ssa.api.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.i2i.ssa.api.order.dto.order.OrderResponseCollectionDTO;
import com.i2i.ssa.api.order.dto.order.OrderResponseDTO;
import com.i2i.ssa.api.order.service.OrderService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
	static final String BASE_URL = "http://localhost:8092/api/v1/order";

	@InjectMocks
	private OrderController controller;

	@Mock
	private OrderService service;


	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.defaultRequest(get("").accept(MediaType.APPLICATION_JSON))
				.build();

	}

	@Test
	void findOrderById() throws Exception {
		String uri = BASE_URL +"/{id}";
		UUID uuid = UUID.randomUUID();
		OrderResponseDTO responseDto = OrderResponseDTO.builder()
				.orderId(uuid)
				.build();

		when(service.findOrderById(any())).thenReturn(responseDto);

		ResultActions resultActions = mockMvc.perform(get(uri, uuid));
		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void getCustomerOrders() throws Exception {
		String uri = BASE_URL +"/customer/{customerId}";
		UUID uuid = UUID.randomUUID();
		List<OrderResponseDTO> responseDto = List.of(OrderResponseDTO.builder()
				.orderId(uuid)
				.build());
		OrderResponseCollectionDTO orderResponseCollectionDTO = OrderResponseCollectionDTO.builder()
				.orders(responseDto)
				.build();

		when(service.findOrdersByCustomerId(any())).thenReturn(orderResponseCollectionDTO);

		ResultActions resultActions = mockMvc.perform(get(uri, uuid));
		resultActions.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void createOrderFromCart() {
	}

	private static <T> String getJson(T t) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(t);
	}
}