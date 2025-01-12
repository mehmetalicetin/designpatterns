package com.i2i.ssa.api.cart.model;

import com.i2i.ssa.api.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "cart")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cart extends BaseModel {
	@Column(nullable = false, name = "customer_id")
	private UUID          customerId;

	@Column(nullable = false, updatable = false, name = "cdate")
	private LocalDateTime createDate;

	@Column(name = "udate")
	private LocalDateTime lastUpdate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cart_id")
	private List<CartItem> items;

	@Builder
	public Cart(UUID id, UUID customerId, LocalDateTime createDate, LocalDateTime lastUpdate, List<CartItem> items) {
		super(id);
		this.customerId = customerId;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.items = items;
	}

	@PrePersist
	protected void onCreate() {
		this.createDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastUpdate = LocalDateTime.now();
	}

	public void addCartItem(CartItem item) {
		this.items.add(item);
	}
}
