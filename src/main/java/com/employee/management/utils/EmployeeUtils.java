package com.employee.management.utils;

import java.util.Date;

import com.employee.management.dto.EmployeeDTO;
import com.employee.management.entity.Employee;
import com.employee.management.entity.EmployeeRoleMaster;
import com.employee.management.entity.EmployeeRoleMasterId;
import com.employee.management.entity.RoleMaster;

public class EmployeeUtils {
	
	public static Employee copyEmployeeFromDto(Employee employee, EmployeeDTO employeeDto) {
		employee.setFirstName(employeeDto.getFirstName());
		employee.setMiddleName(employeeDto.getMiddleName());
		employee.setLastName(employeeDto.getLastName());
		employee.setDateOfJoining(employeeDto.getDateOfJoining());
		employee.setStatus(1);
		return employee;
	}
	
	public static RoleMaster copyRoleMasterFromDto(RoleMaster roleMaster, EmployeeDTO employeeDto) {
		roleMaster.setRoleName(employeeDto.getRole());
		roleMaster.setStatus(1);
		return roleMaster;
	}
	
	public static EmployeeRoleMaster createEmployeeRoleMaster(Employee employee, RoleMaster role) {
		EmployeeRoleMaster employeeRole = new EmployeeRoleMaster();
		EmployeeRoleMasterId id = new EmployeeRoleMasterId();
		id.setEmployeeId(employee.getId());
		id.setRoleMasterId(role.getId());
		employeeRole.setId(id);
		employeeRole.setEmployee(employee);
		employeeRole.setRoleMaster(role);
		employeeRole.setEffectiveDate(new Date());
		return employeeRole;
	}
	
	public static EmployeeDTO getEmpoyeeDtoFromEmployee(Employee emp) {
		EmployeeDTO empDto = new EmployeeDTO();
		empDto.setEmpId(emp.getId());
		empDto.setFirstName(emp.getFirstName());
		empDto.setLastName(emp.getLastName());
		empDto.setMiddleName(emp.getMiddleName());
		empDto.setDateOfJoining(emp.getDateOfJoining());
		empDto.setDateOfExit(emp.getDateOfExit());
		empDto.setStatus(emp.getStatus());
		return empDto;
	}

}
