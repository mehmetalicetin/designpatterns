package com.i2i.ssa.api.order.dto.orderitem;

import com.i2i.dto.BaseRequestDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderItemResponseDTO extends BaseRequestDto {
	private UUID   productId;
	private String productName;
	private int    quantity;
	private double unitPrice;
	private double unitDiscount;
	private double totalPrice;
	private double totalDiscount;
}
