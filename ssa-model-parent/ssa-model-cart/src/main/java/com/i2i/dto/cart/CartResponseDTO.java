package com.i2i.dto.cart;

import com.i2i.dto.BaseResponseDto;
import com.i2i.dto.cartItem.CartItemRequestCollectionDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartResponseDTO extends BaseResponseDto {
	private UUID                  customerId;
	private LocalDateTime         createDate;
	private LocalDateTime                lastUpdate;
	private CartItemRequestCollectionDTO cartItemRequestCollectionDTO;
}
