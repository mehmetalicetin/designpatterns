package com.i2i.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class CustomerResponseDTO extends BaseResponseDto {
	private UUID          id;
	private String        name;
	private String        address;
	private LocalDateTime createDate;

	@Builder
	public CustomerResponseDTO(UUID id, String name, String address, LocalDateTime createDate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.createDate = createDate;
	}
}
