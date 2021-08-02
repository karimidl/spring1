package com.server.hr.service;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.exceptions.UserNotFoundException;
import com.server.hr.model.Employee;
import com.server.hr.reposi.EmployeeRepo;



@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		
		this.employeeRepo = employeeRepo;
	}
	public Employee addEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}
	public List<Employee> findAllEmployee(){
		return employeeRepo.findAll();
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public List<Employee> getEmployeesByIsArchived(Boolean isArchived) {
		return employeeRepo.getEmployeeByIsArchived(isArchived);
	}
	public void changeEmployeeStatus(Long id) {
		Employee employee = this.findEmployeeById(id);
		employee.setIsArchived(!employee.getIsArchived());
	}
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("Agent N°" +id+ "pas trouvé"));
	}
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	

}
