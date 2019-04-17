package com.shopping.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.billing.entity.Customer;
import com.shopping.billing.entity.ShoppingDetail;


@Repository
public interface ShoppingDetailDAO extends JpaRepository<ShoppingDetail, Long>{

	
	public List<ShoppingDetail> findByCustomerAndStatus(Customer customer, String status);

}
