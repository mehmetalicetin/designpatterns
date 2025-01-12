package com.i2i.dto.cartItem;

import com.i2i.dto.BaseRequestDto;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartItemRequestCollectionDTO extends BaseRequestDto {
	List<CartItemRequestDTO> cartItems;
}
