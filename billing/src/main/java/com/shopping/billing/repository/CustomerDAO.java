package com.shopping.billing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.billing.entity.Customer;

@Repository
public interface CustomerDAO  extends JpaRepository<Customer, Long>{

	
	public Optional<Customer> findByCustomerId(Long customerId);
	
}
