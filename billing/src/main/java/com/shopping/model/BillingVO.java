package com.shopping.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BillingVO {

	private long customerId;
	private String customerName;
	private List<Item> items;
	private BigDecimal totalAmountBeforeDisc;
	private BigDecimal totalDiscount;
	private BigDecimal totalSalesTax;
	private BigDecimal payableAmount;
	private Date date;
	private Message message;
	
}
