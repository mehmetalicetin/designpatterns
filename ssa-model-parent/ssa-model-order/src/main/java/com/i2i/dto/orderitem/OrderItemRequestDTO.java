package com.i2i.dto.orderitem;

import com.i2i.dto.BaseRequestDto;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderItemRequestDTO extends BaseRequestDto {
	private UUID productId;
	private String productName;
	private int quantity;
	private double unitPrice;
	private double unitDiscount;
	private double totalPrice;
	private double totalDiscount;
}
