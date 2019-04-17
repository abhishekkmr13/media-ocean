package com.shopping.billing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.billing.exceptions.BillingBusinessException;
import com.shopping.billing.service.BillingService;
import com.shopping.billing.utils.LogDecorator;
import com.shopping.billing.utils.LogHeaderEnum;
import com.shopping.model.BillingVO;
import com.shopping.model.Message;

@RestController
@RequestMapping("/app/v1")
public class BillingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BillingController.class);

	@Autowired
	BillingService billingService;

	@RequestMapping(value="/bill/{customerId}",  method = RequestMethod.GET)
	public BillingVO getBill(@PathVariable("customerId") long customerId) {

		BillingVO billingVO = null;

		LogDecorator.addLoggerHeader(LogHeaderEnum.CUSTOMER_ID, ""+customerId);

		try {
			billingVO = billingService.checkOut(customerId);
			Message msg = new Message();
			msg.setText("Bill is generated.");
			msg.setStatusCode("SUCCESS");
			billingVO.setMessage(msg);
		}catch (BillingBusinessException billingBusinessException) {
			billingVO = new BillingVO();

			LOGGER.error("Failed to generate bill, message="+billingBusinessException.getMessage());

			Message msg = new Message();
			msg.setText(billingBusinessException.getMessage());
			msg.setStatusCode("FAILED");
			billingVO.setMessage(msg);
		}
		catch (Exception e) {
			billingVO = new BillingVO();
			
			LOGGER.error("Failed to generate bill, message="+e.getMessage());

			Message msg = new Message();
			msg.setText("Internal server error.");
			msg.setStatusCode("FAILED");
			billingVO.setMessage(msg);
		}

		return billingVO;
	}

}
