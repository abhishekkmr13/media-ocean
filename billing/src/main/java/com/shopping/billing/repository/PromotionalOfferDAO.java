package com.shopping.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.billing.entity.Category;
import com.shopping.billing.entity.PromotionalOffer;

public interface PromotionalOfferDAO extends JpaRepository<PromotionalOffer, Long>{

	public List<PromotionalOffer> findByCategory(Category category);
}
