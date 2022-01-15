package com.employee.management.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public EmployeeException(String message) {
		this.message = message;
	}
}
