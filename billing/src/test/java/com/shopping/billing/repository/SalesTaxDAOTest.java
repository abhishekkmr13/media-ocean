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
import com.shopping.billing.entity.SalesTax;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesTaxDAOTest {
		
	
	@Autowired
	SalesTaxDAO salesTaxDAO;
	
	@Test
	public void testSalesTaxForFitnessAndSports(){
		
		Category category =  new Category();
		category.setCategoryId(new Long(1));
		category.setCategoryName("Fitness and Sports");
		
		List<SalesTax> salesTax = salesTaxDAO.findByCategory(category);
		
		assertNotNull(salesTax);
		assertEquals(salesTax.size(), 1);
	}
}
