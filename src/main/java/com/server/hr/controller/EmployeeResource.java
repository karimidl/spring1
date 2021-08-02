package com.server.hr.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.hr.model.Employee;
import com.server.hr.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeResource {
	private final EmployeeService emplyeeService;

	public EmployeeResource(EmployeeService emplyeeService) {

		this.emplyeeService = emplyeeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = emplyeeService.findAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/listArchived")
	public ResponseEntity<List<Employee>> getArchivedEmployees() {
		List<Employee> employees = emplyeeService.getEmployeesByIsArchived(true);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/listActivated")
	public ResponseEntity<List<Employee>> getActivatedEmployees() {
		List<Employee> employees = emplyeeService.getEmployeesByIsArchived(false);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PutMapping("/archive/{id}")
	public ResponseEntity<String> changeStatusEmployee(@PathVariable("id") Long id) {
		emplyeeService.changeEmployeeStatus(id);
		return new ResponseEntity<String>("Employee status changed successfully !!!", HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = emplyeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee newemployee = emplyeeService.addEmployee(employee);
		return new ResponseEntity<>(newemployee, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updateemployee = emplyeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateemployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		emplyeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee is deleted successfully !!!", HttpStatus.OK);
	}

}
