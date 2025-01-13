package com.i2i.ssa.api.inventory.service;

import com.i2i.dto.ProductRequestDTO;
import com.i2i.dto.ProductResponseCollectionDTO;
import com.i2i.dto.ProductResponseDTO;
import com.i2i.ssa.api.core.service.BaseService;
import com.i2i.ssa.api.inventory.convert.ProductMapper;
import com.i2i.ssa.api.inventory.model.Product;
import com.i2i.ssa.api.inventory.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService extends BaseService<Product>{
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);

	private final ProductRepository repository;
    private final ProductMapper     productMapper;

    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        super(repository);
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public ProductResponseCollectionDTO getProducts() {
        Iterable<Product> products = findAll();
		ProductResponseCollectionDTO productResponseCollectionDTO = productMapper.toProductResponseCollectionDTO(products);
		log.info("[getProducts()]... completed successfully");
		return productResponseCollectionDTO;
	}

	public ProductResponseDTO getProductById(UUID id) {
		Optional<Product> product = findById(id);
		if (product.isPresent()) {
			return productMapper.toProductResponseDTO(product.get());
		}
		log.info("Cannot find product by id: {}", id);
		throw new RuntimeErrorException(new Error(), "Cannot find product by id");
	}

    public void decrementQuantity(UUID id, Integer quantity) {
        Product product = getProduct(id);
        if (product == null)
            return;
        boolean isBalanceEnough = product.getStockQuantity() >= quantity;

       if (!isBalanceEnough) {
        return;
       }


       repository.decrementQuantity(id, quantity);

	   log.info("[decrementQuantity()]... completed successfully");
	}

    private Product getProduct(UUID id) {
        Optional<Product> optionalProduct = findById(id);
		return optionalProduct.orElse(null);
	}

    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toProduct(productRequestDTO);
		ProductResponseDTO responseDTO = productMapper.toProductResponseDTO(save(product));
		log.info("[create()]... completed successfully");
		return responseDTO;
    }
}
