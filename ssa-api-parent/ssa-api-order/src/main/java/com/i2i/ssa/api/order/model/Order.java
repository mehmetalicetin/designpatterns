package com.i2i.ssa.api.order.model;

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
@Table(name = "orders")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Order extends BaseModel {

	@Column(nullable = false)
	private UUID customerId;

	@Column(nullable = false, length = 100)
	private String customerName;

	@Column(nullable = false)
	private String customerAddress;

	@Column(nullable = false)
	private double totalPrice;

	@Column(nullable = false)
	private double totalDiscount;

	@Column(nullable = false)
	private int uniqueProducts;

	@Column(nullable = false)
	private int totalProducts;

	@Column(nullable = false)
	private LocalDateTime createDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private List<OrderItem> items;

	@Builder
	public Order(UUID id, UUID customerId, String customerName, String customerAddress, double totalPrice, double totalDiscount, int uniqueProducts,
			int totalProducts, LocalDateTime createDate, List<OrderItem> items) {
		super(id);
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.totalPrice = totalPrice;
		this.totalDiscount = totalDiscount;
		this.uniqueProducts = uniqueProducts;
		this.totalProducts = totalProducts;
		this.createDate = createDate;
		this.items = items;
	}
}
