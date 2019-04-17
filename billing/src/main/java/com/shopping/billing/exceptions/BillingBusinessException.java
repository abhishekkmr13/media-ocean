package com.shopping.billing.exceptions;

public class BillingBusinessException extends BaseException {

	private static final long serialVersionUID = 7845237181439002352L;

	public BillingBusinessException(String message) {
		super(message);
	}
	
	public BillingBusinessException(String message, Throwable t) {
		super(message);
	}

}
