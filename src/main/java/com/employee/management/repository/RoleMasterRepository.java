package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.RoleMaster;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Integer> {

	RoleMaster findByRoleName(String role);

}
