package com.shopping.billing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class Customer {

	@Id
    @GeneratedValue
    @Column(name = "customer_id", nullable = false)
	private Long customerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone")
	private Long phone;
	
}
