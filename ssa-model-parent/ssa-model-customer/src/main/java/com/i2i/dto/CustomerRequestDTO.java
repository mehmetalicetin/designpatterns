package com.i2i.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerRequestDTO extends BaseRequestDto {
	private String        name;
	private String        address;
}
