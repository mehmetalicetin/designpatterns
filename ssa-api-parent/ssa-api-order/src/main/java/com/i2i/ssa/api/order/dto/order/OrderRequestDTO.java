package com.i2i.ssa.api.order.dto.order;

import com.i2i.dto.BaseRequestDto;
import com.i2i.ssa.api.order.dto.orderitem.OrderItemRequestDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequestDTO extends BaseRequestDto {
	private UUID                      customerId;
	private String                    customerName;
	private String                    customerAddress;
	private double                    totalPrice;
	private double                    totalDiscount;
	private int                       uniqueProducts;
	private int                       totalProducts;
	private List<OrderItemRequestDTO> items;
}
