package com.shopping.billing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.billing.entity.ShoppingDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingDetailServiceTest {

	@Autowired
	ShoppingDetailService shoppingDetailService;
	
	@Test
	public void testSalesTaxForExistingCustomer() {
		
		List<ShoppingDetail> shoppingDetails = shoppingDetailService.getShoppingDetailsBy(1L);
		
		assertNotNull(shoppingDetails);
	}
	
	@Test
	public void testSalesTaxForNonExistingCustomer() {
		
		List<ShoppingDetail> shoppingDetails = shoppingDetailService.getShoppingDetailsBy(1321L);
		
		assertEquals(shoppingDetails.size(), 0);
	}
}