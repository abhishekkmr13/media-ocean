package com.shopping.billing.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id", nullable = false)	
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Category productCategory;

}
