package com.employee.management.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private int empId;
	
	private String firstName;
	
	private String middleName;

	private String lastName;
	
	private Date dateOfJoining;
	
	private Date dateOfExit;
	
	private String role;
	
	private int status;
}
