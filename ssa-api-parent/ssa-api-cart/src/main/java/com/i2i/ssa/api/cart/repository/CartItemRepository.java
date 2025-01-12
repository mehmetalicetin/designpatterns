package com.i2i.ssa.api.cart.repository;

import com.i2i.ssa.api.cart.model.CartItem;
import com.i2i.ssa.api.core.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface CartItemRepository extends BaseRepository<CartItem> {
	@Modifying
	@Transactional
	@Query(value = "delete from cart_item where product_id = :productId and quantity = :quantity and cart_id = :cartId", nativeQuery = true)
	void removeProductWithGivenIdAndGivenQuantity(@Param("cartId") UUID cartId, @Param("productId") UUID productId, @Param("quantity") Integer quantity);
}
