package com.i2i.dto.order;

import com.i2i.dto.BaseResponseDto;
import com.i2i.dto.orderitem.OrderItemResponseDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderResponseDTO extends BaseResponseDto {
	private UUID                       orderId;
	private UUID                       customerId;
	private String                     customerName;
	private String                     customerAddress;
	private double                     totalPrice;
	private double                     totalDiscount;
	private int                        uniqueProducts;
	private int                        totalProducts;
	private LocalDateTime              createDate;
	private List<OrderItemResponseDTO> items;
}
