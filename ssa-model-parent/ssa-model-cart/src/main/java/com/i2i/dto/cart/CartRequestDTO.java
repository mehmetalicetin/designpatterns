package com.i2i.dto.cart;

import com.i2i.dto.BaseRequestDto;
import com.i2i.dto.cartItem.CartItemRequestCollectionDTO;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartRequestDTO extends BaseRequestDto {
	private UUID                         customerId;
	private CartItemRequestCollectionDTO cartItemRequestCollectionDTO;
}
