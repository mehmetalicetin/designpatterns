package com.i2i.dto.cartItem;

import com.i2i.dto.BaseRequestDto;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartItemRequestDTO extends BaseRequestDto {
	private UUID           productId;
	private int            quantity;
}
