package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.dto.EmployeeDTO;
import com.employee.management.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="create-employee")
	public String createEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.createEmployee(employee);
		return "Employee created successfully!";
	}
	
	@PostMapping(value="update-employee")
	public String updateEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.updateEmployee(employee);
		return "Employee updated successfully!";
	}
	
	@DeleteMapping(value="remove-employee/{employeeId}")
	public String removeEmployee(@PathVariable(value = "employeeId") int employeeId) {
		employeeService.removeEmployee(employeeId);
		return "Employee removed successfully!";
	}
	
	@GetMapping(value="all")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(value="search/{employeeId}")
	public EmployeeDTO getEmployee(@PathVariable(value = "employeeId") int employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	
}
