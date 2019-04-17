package com.shopping.billing.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LogDecorator {
	private static final Logger logger = LoggerFactory.getLogger(LogDecorator.class);

	public static void addLoggerHeader(LogHeaderEnum header, String value) {

		MDC.put(header.toString(), value);
	}   

	public static void clearLoggerHeaders() {		
		MDC.clear();		
	}
}
