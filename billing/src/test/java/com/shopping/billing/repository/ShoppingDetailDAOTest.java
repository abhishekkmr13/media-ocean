package com.shopping.billing.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.billing.entity.Customer;
import com.shopping.billing.entity.ShoppingDetail;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingDetailDAOTest {
	
	@Autowired
	private ShoppingDetailDAO shoppingDetailDAO;
	
	
	@Test
	public void testShoppingDetailForCustomer(){
		
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		
		List<ShoppingDetail> shoppingDetails = shoppingDetailDAO.findByCustomerAndStatus(customer, "PENDING");
		
		assertNotNull(shoppingDetails);
		assertTrue(shoppingDetails.size()>0);
	}

}
