package com.shopping.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.billing.entity.Category;
import com.shopping.billing.entity.SalesTax;

public interface SalesTaxDAO extends JpaRepository<SalesTax, Long>{

	public List<SalesTax> findByCategory(Category category);
	
}
