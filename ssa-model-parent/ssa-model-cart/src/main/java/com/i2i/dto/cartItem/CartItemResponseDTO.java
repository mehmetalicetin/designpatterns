package com.i2i.dto.cartItem;

import com.i2i.dto.BaseResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartItemResponseDTO extends BaseResponseDto {
	private UUID           productId;
	private int            quantity;
	private LocalDateTime  createDate;
	private LocalDateTime  lastUpdate;
}
