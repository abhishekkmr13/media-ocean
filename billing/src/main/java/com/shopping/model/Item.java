package com.shopping.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Item {

	private long itemId;
	private String itemName;
	private BigDecimal unitPrice;
	private BigDecimal discountPercentage;
	private BigDecimal discount;
	private BigDecimal salesTax;
	private BigDecimal salesTaxAmount;
	private long numberOfUnits;
	private BigDecimal finalPayableAmount;
	

}
