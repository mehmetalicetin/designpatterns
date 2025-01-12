package com.i2i.ssa.api.inventory.service;

import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import com.i2i.ssa.api.inventory.convert.ProductMapper;
import com.i2i.ssa.api.inventory.model.Product;
import com.i2i.ssa.api.inventory.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@InjectMocks
	ProductService service;

	@Mock
	ProductRepository repository;

	@Mock
	ProductMapper converter;

	@Mock
	Product product;

	@Mock
	UUID uuid;

	MockMvc mockMvc;

	@Mock
	ProductResponseDTO responseDto;

	@Mock
	ProductRequestDTO requestProductDto;

	@Mock
	ProductResponseCollectionDTO responseCollectionProductDto;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}

	@Test
	void getProducts() {
		when(repository.findAll()).thenReturn(List.of());
		when(converter.toProductResponseCollectionDTO(any(Iterable.class))).thenReturn(responseCollectionProductDto);
		service.getProducts();
	}

	@Test
	void getProductById() {
		when(repository.findById(uuid)).thenReturn(Optional.ofNullable(product));
		when(converter.toProductResponseDTO(any(Product.class))).thenReturn(responseDto);
		service.getProductById(uuid);
	}

	@Test
	void decrementQuantity() {
		when(repository.findById(uuid)).thenReturn(Optional.ofNullable(product));
		service.decrementQuantity(uuid, anyInt());
	}

	@Test
	void create() {
		when(converter.toProduct(any(ProductRequestDTO.class))).thenReturn(product);
		when(repository.save(any(Product.class))).thenReturn(product);
		when(converter.toProductResponseDTO(product)).thenReturn(responseDto);

		service.create(requestProductDto);
	}
}