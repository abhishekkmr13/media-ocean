package com.shopping.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.billing.entity.Product;

@Repository
public interface ProductDAO  extends JpaRepository<Product, Long>{

}
