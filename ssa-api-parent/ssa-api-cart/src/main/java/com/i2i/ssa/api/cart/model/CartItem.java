package com.i2i.ssa.api.cart.model;

import com.i2i.ssa.api.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cart_item")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CartItem extends BaseModel {
	@Column(nullable = false, name = "product_id")
	private UUID productId;

	@Column(nullable = false, name = "quantity")
	private int quantity;

	@Column(nullable = false, name = "cdate")
	private LocalDateTime createDate;

	@Column(name = "udate")
	private LocalDateTime lastUpdate;

	@Builder
	public CartItem(UUID id, UUID productId, int quantity, LocalDateTime createDate, LocalDateTime lastUpdate) {
		super(id);
		this.productId = productId;
		this.quantity = quantity;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
	}

	@PrePersist
	protected void onCreate() {
		this.createDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastUpdate = LocalDateTime.now();
	}
}
