package com.shopping.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.billing.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long>{
	
}
