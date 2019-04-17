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
@Table(name="promotional_offer")
@Data
public class PromotionalOffer {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "discountPercentage")
	private Long discountPercentage;
	
	@Column(name = "valid_from")
	private Date validFrom;
	
	@Column(name = "valid_thru")
	private Date validThru;
	
}
