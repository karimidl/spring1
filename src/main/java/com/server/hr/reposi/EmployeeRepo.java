package com.server.hr.reposi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.hr.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	void deleteEmployeeById(Long id);

  Optional<Employee> findEmployeeById(Long id);

  List<Employee> getEmployeeByIsArchived(Boolean isArchived);

}
