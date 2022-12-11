package com.leave.leaveproject.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leave.leaveproject.restcontrollers.DepartmentController;

public class ApplicationException extends RuntimeException {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);
	
	public ApplicationException (String message) {
		super(message);
		LOGGER.info("Got an exception. " + message);
	}

}