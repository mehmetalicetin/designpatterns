package com.i2i.ssa.api.inventory.model;

import com.i2i.ssa.api.core.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel {
    
    @Column(nullable = false)
    private String name;
    
    @Column
    private String description;
    
    @Column(nullable = false)
    private Double price;
    
    @Column
    private Double discount;
    
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;
    
    @Column(name = "image_url")
    private String imageUrl;

    public Product() {
    }

    @Builder
    public Product(UUID uuid, String name, String description, Double price, Double discount, Integer stockQuantity, String imageUrl) {
        super(uuid);
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
    }
}