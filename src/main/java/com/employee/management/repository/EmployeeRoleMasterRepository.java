package com.employee.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.EmployeeRoleMaster;
import com.employee.management.entity.EmployeeRoleMasterId;

@Repository
public interface EmployeeRoleMasterRepository extends JpaRepository<EmployeeRoleMaster, EmployeeRoleMasterId> {
	List<EmployeeRoleMaster> findByEmployeeId(int employeeId);
	List<EmployeeRoleMaster> findByRoleMasterId(int roleId);
}
