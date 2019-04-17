package com.shopping.billing.utils;

import java.util.Arrays;

public enum LogHeaderEnum {
	CUSTOMER_ID("CUSTOMER_ID");
	
	LogHeaderEnum(String header) {
		this.header = header;
	}
	
	private String header;
	
	public static LogHeaderEnum fromString(String s) throws IllegalArgumentException {
	      return Arrays.stream(LogHeaderEnum.values())
	              .filter(v -> v.header.equals(s))
	              .findFirst()
	              .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
	  }
	
	@Override
	  public String toString() {
	    return this.header;
	  }
}
