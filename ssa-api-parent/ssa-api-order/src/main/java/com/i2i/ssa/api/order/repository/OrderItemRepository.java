package com.i2i.ssa.api.order.repository;

import com.i2i.ssa.api.core.repository.BaseRepository;
import com.i2i.ssa.api.order.model.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends BaseRepository<OrderItem> {
}
