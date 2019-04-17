package com.shopping.billing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.billing.entity.Customer;
import com.shopping.billing.entity.Product;
import com.shopping.billing.entity.PromotionalOffer;
import com.shopping.billing.entity.SalesTax;
import com.shopping.billing.entity.ShoppingDetail;
import com.shopping.billing.exceptions.BillingBusinessException;
import com.shopping.billing.repository.CustomerDAO;
import com.shopping.model.BillingVO;
import com.shopping.model.Item;

@Service
public class BillingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BillingService.class);

	@Autowired
	SalesTaxService salesTaxService;

	@Autowired
	PromotionalOfferService promotionalOfferService;

	@Autowired
	ShoppingDetailService shoppingDetailService;

	@Autowired
	CustomerDAO customerDAO;

	public BillingVO checkOut(Long customerId) throws BillingBusinessException{

		//Get Customer Detail
		Optional<Customer> customer = customerDAO.findByCustomerId(customerId);
		
		if(customer.isPresent()==false) 
			throw new BillingBusinessException("Customer does not exist.");
		
		LOGGER.info("Starting billing for customer=["+customer.get().getName()+"]");

		List<ShoppingDetail> shoppingDetails = getShoppingDetails(customerId);
		BillingVO billingDetail =  new BillingVO();
		
		
		//Setting Customer details
		billingDetail.setCustomerId(customerId);
		billingDetail.setCustomerName(customer.get().getName());
		billingDetail.setDate(new Date());
		
		//Define Counters to calculate value
		double totalDiscountedAmount = 0d;
		double totalSalesTaxAmount = 0d;
		double totalPayable = 0d;
		double totalAmountBeforeDiscount = 0d;

		List<Item> items = new ArrayList<>();

		for(ShoppingDetail shoppingDetail : shoppingDetails) {
			
			Product product = shoppingDetail.getProduct();
			
			//Setting up item related info
			Item item = new Item();
			item.setItemId(product.getProductId());
			item.setItemName(product.getProductName());
			item.setUnitPrice(product.getUnitPrice());
			item.setNumberOfUnits(shoppingDetail.getQuantity());

			BigDecimal originalPrice = product.getUnitPrice().multiply(new BigDecimal(shoppingDetail.getQuantity()));

			BigDecimal discountPercentage = getPromotionalDiscountFor(product.getProductCategory().getCategoryId());
			BigDecimal salesTaxPercentage = getSalesTaxFor(product.getProductCategory().getCategoryId());

			BigDecimal discountedAmount = getDiscountedAmount(originalPrice, discountPercentage);
			BigDecimal salesTaxAmount = getSalesTaxAmount(discountedAmount, salesTaxPercentage);

			item.setDiscountPercentage(discountPercentage);
			item.setDiscount(discountedAmount);

			item.setSalesTax(salesTaxPercentage);
			item.setSalesTaxAmount(salesTaxAmount);

			item.setFinalPayableAmount(originalPrice.subtract(discountedAmount).add(salesTaxAmount));

			totalDiscountedAmount=totalDiscountedAmount+discountedAmount.doubleValue();
			totalSalesTaxAmount=totalSalesTaxAmount+salesTaxAmount.doubleValue();
			totalPayable=totalPayable+item.getFinalPayableAmount().doubleValue();
			totalAmountBeforeDiscount=totalAmountBeforeDiscount+originalPrice.doubleValue();

			items.add(item);
		}

		
		//Setting up all the values at bill-level
		billingDetail.setItems(items);
		billingDetail.setTotalAmountBeforeDisc(new BigDecimal(totalAmountBeforeDiscount));
		billingDetail.setTotalDiscount(new BigDecimal(totalDiscountedAmount));
		billingDetail.setTotalSalesTax(new BigDecimal(totalSalesTaxAmount));
		billingDetail.setPayableAmount(new BigDecimal(totalPayable));

		return billingDetail;
	}

	public List<ShoppingDetail> getShoppingDetails(Long customerId) {

		return shoppingDetailService.getShoppingDetailsBy(customerId);
	}

	public void generateInvoice() {

	}

	public BigDecimal getSalesTaxFor(Long categoryId) {

		SalesTax salesTax = salesTaxService.getSalesTaxFor(categoryId);

		return salesTax == null ? new BigDecimal(0) : new BigDecimal(salesTax.getSalesTax());

	}

	public BigDecimal getPromotionalDiscountFor(Long categoryId) {

		PromotionalOffer promotionalOffer = promotionalOfferService.getPromotionalOfferFor(categoryId);

		return promotionalOffer == null ? new BigDecimal(0) : new BigDecimal(promotionalOffer.getDiscountPercentage());
	}

	public BigDecimal getDiscountedAmount(BigDecimal originalPrice, BigDecimal discountPercentage) {

		BigDecimal finalPrice = originalPrice.multiply(
				discountPercentage).divide(new BigDecimal(100));
		
		LOGGER.info("Discount for originalPrice=["+originalPrice+"] salesTaxPercentage=["+discountPercentage+"] discount=["+finalPrice+"]");
		
		return finalPrice;
	}

	public BigDecimal getSalesTaxAmount(BigDecimal originalPrice, BigDecimal salesTaxPercentage) {

		BigDecimal finalPrice = originalPrice.multiply(
				salesTaxPercentage).divide(new BigDecimal(100));
		
		LOGGER.info("Sales-Tax for originalPrice=["+originalPrice+"] salesTaxPercentage=["+salesTaxPercentage+"] sales-tax=["+finalPrice+"]");
		
		return finalPrice;
	}
}
