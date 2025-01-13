package com.i2i.ssa.api.inventory.convert;

import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import com.i2i.ssa.api.inventory.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductMapperTest {
	private final ProductMapper productMapper = new ProductMapper();

	@Test
	void toProductResponseCollectionDTOProducts() {
		ProductResponseCollectionDTO converted = productMapper.toProductResponseCollectionDTO(List.of(Product.builder().name("A-12").build()));
		assertNotNull(converted);
		Optional<ProductResponseDTO> any = converted.getProducts().stream().findAny();
		ProductResponseDTO dto = any.orElse(null);
		assert dto != null;
		assertEquals(dto.getName(), "A-12");
	}

	@Test
	void toProductResponseCollectionDTOProduct() {
		ProductResponseDTO converted = productMapper.toProductResponseDTO(Product.builder().name("A-12").build());
		assertNotNull(converted);
		assertEquals(converted.getName(), "A-12");
	}

	@Test
	void toProductResponseCollectionDTORequestProduct() {
		Product converted = productMapper.toProduct(ProductRequestDTO.builder().name("A-12").build());
		assertNotNull(converted);
		assertEquals(converted.getName(), "A-12");
	}
}