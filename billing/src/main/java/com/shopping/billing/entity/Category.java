package com.shopping.billing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="category")
@Data
public class Category {
	
	@Id
    @GeneratedValue
    @Column(name = "category_id", nullable = false)	
	private Long categoryId;
	
	@Column(name = "category_name")
	private String categoryName;

}
