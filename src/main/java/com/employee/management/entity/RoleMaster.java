package com.employee.management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "ROLEMASTER")
@Data
public class RoleMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String roleName;
	
	@NotNull
	private int status;
	
	@OneToMany(mappedBy = "roleMaster")
    private Set<EmployeeRoleMaster> employeeRoleMaster = new HashSet<>();
	
	
}
