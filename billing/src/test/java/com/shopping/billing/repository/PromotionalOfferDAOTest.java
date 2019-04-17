package com.shopping.billing.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.billing.entity.Category;
import com.shopping.billing.entity.PromotionalOffer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionalOfferDAOTest {
	
	@Autowired
	PromotionalOfferDAO promotionalOfferDAO;
	
	@Test
	public void testPromotionalOfferForFitnessAndSports(){
		
		Category category =  new Category();
		category.setCategoryId(new Long(1));
		category.setCategoryName("Fitness and Sports");
		
		List<PromotionalOffer> promotionalOffer = promotionalOfferDAO.findByCategory(category);
		
		assertNotNull(promotionalOffer);
		assertEquals(promotionalOffer.size(), 1);
	}

}
