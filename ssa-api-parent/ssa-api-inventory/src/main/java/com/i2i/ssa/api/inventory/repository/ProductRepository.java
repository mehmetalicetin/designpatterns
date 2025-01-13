package com.i2i.ssa.api.inventory.repository;

import com.i2i.ssa.api.core.repository.BaseRepository;
import com.i2i.ssa.api.inventory.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface ProductRepository extends BaseRepository<Product> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET stock_quantity = stock_quantity - :quantity WHERE id = :id", nativeQuery = true)
    void decrementQuantity(@Param("id") UUID id, @Param("quantity") Integer quantity);
}

