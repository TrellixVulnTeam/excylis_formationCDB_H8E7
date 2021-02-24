package com.excilys.formationCDB.exception;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class CustomSQLException extends Exception {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CompanyKeyInvalidException.class);

	public CustomSQLException() {
		logger.error("SQL Error:");

	}

	public CustomSQLException(String message) {
		super(message);
		logger.error("SQL Error:" + message);

	}
}
