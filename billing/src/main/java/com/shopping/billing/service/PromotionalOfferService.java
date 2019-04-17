package com.shopping.billing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.billing.entity.Category;
import com.shopping.billing.entity.PromotionalOffer;
import com.shopping.billing.repository.PromotionalOfferDAO;

@Service
public class PromotionalOfferService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionalOfferService.class);
	
	@Autowired
	PromotionalOfferDAO promotionalOfferDAO;

	public PromotionalOffer getPromotionalOfferFor(Long categoryId) {

		LOGGER.info("Checking for PromotionalOffer for category=["+categoryId+"]");
		
		Category category = new Category();
		category.setCategoryId(categoryId);
		List<PromotionalOffer> promotionalOffers =  promotionalOfferDAO.findByCategory(category);

		LOGGER.info("PromotionalOffer found for category=["+categoryId+"] PromotionalOffer=["+promotionalOffers+"]");
		
		return promotionalOffers == null || promotionalOffers.isEmpty() ? null : promotionalOffers.get(0);
	}

}
