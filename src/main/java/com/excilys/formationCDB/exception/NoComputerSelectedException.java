package com.excilys.formationCDB.exception;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class NoComputerSelectedException extends Exception {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CompanyKeyInvalidException.class);

	public NoComputerSelectedException(String message) {
		logger.error("No Computer were selected: " + message);
	}
}
