package com.i2i.dto.order;

import com.i2i.dto.BaseRequestDto;
import com.i2i.dto.orderitem.OrderItemRequestDTO;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
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
