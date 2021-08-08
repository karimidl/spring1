package com.server.hr.service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.exceptions.UserNotFoundException;
import com.server.hr.model.Employee;
import com.server.hr.model.Leave;
import com.server.hr.reposi.EmployeeRepo;
import com.server.hr.reposi.LeaveTypeRepo;



@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepo employeeRepo;
	private final LeaveTypeRepo leaveTypeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo, LeaveTypeRepo leaveTypeRepo) {
		
		this.employeeRepo = employeeRepo;
		this.leaveTypeRepo = leaveTypeRepo;
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
	
	public Employee leaveBalanceCalcul(Employee employee) {
		LocalDate endDate = LocalDate.now().withMonth(12).withDayOfMonth(31);	
		LocalDate startDate = endDate.minusYears(1).withMonth(1).withDayOfMonth(1);
		
		List<Leave> leaves = employee.getLeaves().stream()
				.filter(leave -> leave.getLeaveType().equals(leaveTypeRepo.findLeaveTypeByNom("Administrative")))
						.filter(leave -> leave.getDate_debut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(startDate) 
								&& leave.getDate_debut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(endDate)).collect(Collectors.toList());

		int count = leaves.stream().map(leave -> leave.getDureeConge() - leave.getRestDays()).mapToInt(i-> i.intValue()).sum();
		
		employee.setLeaveBalance(count);
		
		return employee;
	}
	

}
