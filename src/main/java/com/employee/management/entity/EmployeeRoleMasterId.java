package com.employee.management.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class EmployeeRoleMasterId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer employeeId;
	private Integer roleMasterId;

}
