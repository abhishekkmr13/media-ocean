package com.shopping.billing.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.billing.entity.PromotionalOffer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionalOfferServiceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionalOfferService.class);
	
	@Autowired
	PromotionalOfferService promotionalOfferService;

	@Test
	public void testPromotionalOfferForExistingCategory() {
		
		PromotionalOffer promotionalOffer = promotionalOfferService.getPromotionalOfferFor(1L);
		
		assertNotNull(promotionalOffer);
	}
	
	@Test
	public void testPromotionalOfferForNonExistingCategory() {
		
		PromotionalOffer promotionalOffer = promotionalOfferService.getPromotionalOfferFor(100L);
		
		assertNull(promotionalOffer);
	}

}