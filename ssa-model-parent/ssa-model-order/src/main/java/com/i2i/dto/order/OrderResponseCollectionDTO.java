package com.i2i.dto.order;

import com.i2i.dto.BaseResponseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderResponseCollectionDTO extends BaseResponseDto {
	private List<OrderResponseDTO> orders;
}
