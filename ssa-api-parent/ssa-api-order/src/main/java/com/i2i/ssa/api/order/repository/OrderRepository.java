package com.i2i.ssa.api.order.repository;

import com.i2i.ssa.api.core.repository.BaseRepository;
import com.i2i.ssa.api.order.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends BaseRepository<Order> {
	@Query(value = "select * from orders where customer_id=:customerId", nativeQuery = true)
	List<Order> findOrdersByCustomerId(@Param("customerId") UUID customerId);
}
