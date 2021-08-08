package com.server.hr;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.server.hr.model.Employee;
import com.server.hr.reposi.EmployeeRepo;
import com.server.hr.reposi.LeaveTypeRepo;
import com.server.hr.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrserverApplicationTests{
	
	@Autowired
	public LeaveTypeRepo leaveTypeRepo;
	
	@Autowired
	public EmployeeRepo employeeRepo; 
	
	public EmployeeService employeeService;
	
	public HrserverApplicationTests () {
		employeeService = new EmployeeService(employeeRepo, leaveTypeRepo);
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	private void leaveBalanceCalculTest() {
		List<Employee> employees = employeeService.findAllEmployee();
		employees.clear();
	}


}
