package com.i2i.ssa.api.order.service;

import com.i2i.ssa.api.core.repository.BaseRepository;
import com.i2i.ssa.api.core.service.BaseService;
import com.i2i.ssa.api.order.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends BaseService<OrderItem> {
	public OrderItemService(BaseRepository<OrderItem> repository) {
		super(repository);
	}
}
