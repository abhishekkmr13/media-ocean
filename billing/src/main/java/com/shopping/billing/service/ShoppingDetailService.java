package com.shopping.billing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.billing.entity.Customer;
import com.shopping.billing.entity.ShoppingDetail;
import com.shopping.billing.repository.ShoppingDetailDAO;

@Service
public class ShoppingDetailService {

	@Autowired
	ShoppingDetailDAO shoppingDetailDAO;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingDetailService.class);
	
	public List<ShoppingDetail> getShoppingDetailsBy(Long customerId) {
		
		LOGGER.info("Checking for ShoppingDetail for customer=["+customerId+"]");
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		
		List<ShoppingDetail> shoppingDetailList = shoppingDetailDAO.findByCustomerAndStatus(customer, "PENDING");
		
		return shoppingDetailList;
	}
	
}
