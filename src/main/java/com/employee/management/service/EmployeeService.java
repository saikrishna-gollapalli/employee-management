package com.employee.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.dto.EmployeeDTO;
import com.employee.management.entity.Employee;
import com.employee.management.entity.EmployeeRoleMaster;
import com.employee.management.entity.RoleMaster;
import com.employee.management.exception.EmployeeException;
import com.employee.management.repository.EmployeeRespository;
import com.employee.management.repository.EmployeeRoleMasterRepository;
import com.employee.management.repository.RoleMasterRepository;
import com.employee.management.utils.EmployeeUtils;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRespository employeeRepo;

	@Autowired
	private RoleMasterRepository roleRepo;

	@Autowired
	private EmployeeRoleMasterRepository employeeRoleRepo;

	public void createEmployee(EmployeeDTO employeeDto) {
			Employee employee = new Employee();
			if (employeeDto.getEmpId() > 0) {
				try {					
					employee = employeeRepo.findById(employeeDto.getEmpId()).get();
				} catch (NoSuchElementException ex) {
					throw new EmployeeException("Employee not found!");
				}
			}
			employee = EmployeeUtils.copyEmployeeFromDto(employee, employeeDto);
			employeeRepo.save(employee);
			RoleMaster roleMaster = roleRepo.findByRoleName(employeeDto.getRole());
			if (roleMaster == null) {
				roleMaster = new RoleMaster();
			}
			roleMaster = EmployeeUtils.copyRoleMasterFromDto(roleMaster, employeeDto);
			roleRepo.save(roleMaster);
			EmployeeRoleMaster employeeRole = EmployeeUtils.createEmployeeRoleMaster(employee, roleMaster);
			employeeRoleRepo.save(employeeRole);
	}

	public void updateEmployee(EmployeeDTO employee) {
		if (employee.getEmpId() > 0) {
			createEmployee(employee);
		} else {
			throw new EmployeeException("Please provide proper employee id!");
		}
	}

	public void removeEmployee(int employeeId) {
		List<EmployeeRoleMaster> employeeRoles = employeeRoleRepo.findByEmployeeId(employeeId);
		employeeRoleRepo.deleteAllInBatch(employeeRoles);
		Employee employee = employeeRepo.findById(employeeId).get();
		System.out.println(employee.toString());
		employeeRepo.delete(employee);
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> response = new ArrayList<>();
		List<Employee> employees = employeeRepo.findAll();
		for (Employee emp : employees) {
			EmployeeDTO empDto = EmployeeUtils.getEmpoyeeDtoFromEmployee(emp);
			List<EmployeeRoleMaster> employeeRoles = employeeRoleRepo.findByEmployeeId(emp.getId());
			if (!employeeRoles.isEmpty()) {				
				RoleMaster role = employeeRoles.get(0).getRoleMaster();
				empDto.setRole(role.getRoleName());
			}
			response.add(empDto);
		}
		return response;
	}

	public EmployeeDTO getEmployee(int employeeId) {
		try {			
			Employee emp = employeeRepo.findById(employeeId).get();
			return EmployeeUtils.getEmpoyeeDtoFromEmployee(emp);
		} catch (NoSuchElementException ex) {
			throw new EmployeeException("Employee not available on provided id!");
		}
	}
}
