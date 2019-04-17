package com.shopping.billing.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.billing.entity.SalesTax;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesTaxServiceTest {

	@Autowired
	SalesTaxService salesTaxService;
	
	@Test
	public void testSalesTaxForExistingCategory() {
		
		SalesTax salesTax = salesTaxService.getSalesTaxFor(1L);
		
		assertNotNull(salesTax);
	}
	
	@Test
	public void testSalesTaxForNonExistingCategory() {
		
		SalesTax salesTax = salesTaxService.getSalesTaxFor(100L);
		
		assertNull(salesTax);
	}
	
}
