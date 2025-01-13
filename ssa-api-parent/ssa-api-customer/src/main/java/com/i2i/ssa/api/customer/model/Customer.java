package com.i2i.ssa.api.customer.model;

import com.i2i.ssa.api.core.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Customer extends BaseModel {
	@Column(nullable = false , name = "name")
	private String name;
	@Column(nullable = false, name = "address")
	private String address;
	@Column(nullable = false, updatable = false, name = "cdate")
	private LocalDateTime createDate;

	@Builder
	public Customer(UUID id, String name, String address) {
		super(id);
		this.name = name;
		this.address = address;
	}

	@PrePersist
	protected void onCreate() {
		this.createDate = LocalDateTime.now();
	}
}
