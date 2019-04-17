package com.shopping.billing.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shopping_detail")
@Data
public class ShoppingDetail {

	@Id
    @GeneratedValue
    @Column(name = "transaction_id", nullable = false)
	private Long transactionId;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")	
	private Customer customer;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private String status;
	
}
