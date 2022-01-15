package com.employee.management.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Entity
@Data
public class EmployeeRoleMaster {
	@EmbeddedId
    private EmployeeRoleMasterId id;

	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("employeeId")
    private Employee employee;
 
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("roleMasterId")
    private RoleMaster roleMaster;
    
    private Date effectiveDate;
}
