package com.i2i.ssa.api.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "VARCHAR(36)")
	protected UUID id;

}
