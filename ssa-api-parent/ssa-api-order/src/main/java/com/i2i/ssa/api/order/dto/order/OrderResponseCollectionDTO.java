package com.i2i.ssa.api.order.dto.order;

import com.i2i.dto.BaseResponseDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderResponseCollectionDTO extends BaseResponseDto {
	private List<OrderResponseDTO> orders;
}
