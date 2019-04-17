package com.shopping.billing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.billing.controller.BillingController;
import com.shopping.billing.entity.Category;
import com.shopping.billing.entity.SalesTax;
import com.shopping.billing.repository.SalesTaxDAO;


@Service
public class SalesTaxService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SalesTaxService.class);
	
	@Autowired
	SalesTaxDAO salesTaxDAO;
	
	public SalesTax getSalesTaxFor(Long categoryId) {
		
		LOGGER.info("Finding Sales Tax for categoryId="+categoryId);
		
		Category category = new Category();
		category.setCategoryId(categoryId);
		
		List<SalesTax> salesTaxList = salesTaxDAO.findByCategory(category);
		
		LOGGER.info("salesTaxList="+salesTaxList);
		
		return salesTaxList == null || salesTaxList.isEmpty() ? null  : salesTaxList.get(0);
	}
	
}
