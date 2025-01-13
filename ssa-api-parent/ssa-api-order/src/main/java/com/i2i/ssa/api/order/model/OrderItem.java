package com.i2i.ssa.api.order.model;

import com.i2i.ssa.api.core.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "order_item")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrderItem extends BaseModel {

	@Column(nullable = false)
	private UUID productId;

	@Column(nullable = false, length = 100)
	private String productName;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private double unitPrice;

	@Column(nullable = false)
	private double unitDiscount;

	@Column(nullable = false)
	private double totalPrice;

	@Column(nullable = false)
	private double totalDiscount;

	@Builder
	public OrderItem(UUID id, UUID productId, String productName, int quantity, double unitPrice, double unitDiscount, double totalPrice,
			double totalDiscount) {
		super(id);
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitDiscount = unitDiscount;
		this.totalPrice = totalPrice;
		this.totalDiscount = totalDiscount;
	}
}
