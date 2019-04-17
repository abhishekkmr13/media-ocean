package com.shopping.billing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.billing.exceptions.BillingBusinessException;
import com.shopping.model.BillingVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingServiceTest {

	@Autowired
	BillingService billingService;
	
	@Test
	public void testSalesTaxForExistingCategory() {
		
		BigDecimal salesTax = billingService.getSalesTaxFor(1L);
		assertEquals(salesTax, new BigDecimal(10));
	}
	
	
	@Test
	public void testSalesTaxForNonExistingCategory() {
		
		BigDecimal salesTax = billingService.getSalesTaxFor(100L);
		assertEquals(salesTax, new BigDecimal(0));
	}
	
	@Test
	public void testPromotionalOfferForExistingCategory() {
		
		BigDecimal promotionalOffer = billingService.getPromotionalDiscountFor(1L);
		assertEquals(promotionalOffer, new BigDecimal(10));
	}
	
	
	@Test
	public void testPromotionalOfferForNonExistingCategory() {
		
		BigDecimal promotionalOffer = billingService.getPromotionalDiscountFor(110l);
		assertEquals(promotionalOffer, new BigDecimal(0));
	}
	
	@Test
	public void testDiscountedAmountFor10Percent() {
		
		BigDecimal discountedAmoun = billingService.getDiscountedAmount(new BigDecimal(1000), new BigDecimal(10));
		assertEquals(discountedAmoun, new BigDecimal(100));
	}
	
	@Test
	public void testSalesTaxAmountFor10Percent() {
		
		BigDecimal promotionalOffer = billingService.getSalesTaxAmount(new BigDecimal(1000), new BigDecimal(10));
		assertEquals(promotionalOffer, new BigDecimal(100));
	}
	
	@Test
	public void testBillingForValidCustomer() {
		
		
		BillingVO billingVO=null;
		try {
			billingVO = billingService.checkOut(1L);
		} catch (BillingBusinessException e) {

		}
		
		assertNotNull(billingVO);
		assertEquals(billingVO.getCustomerId(), 1L);
	}
	
	@Test(expected=BillingBusinessException.class)
	public void testBillingForInValidCustomer() throws BillingBusinessException {
		
		BillingVO billingVO = billingService.checkOut(1234L);
	}
	
}
