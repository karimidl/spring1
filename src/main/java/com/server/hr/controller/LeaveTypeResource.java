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

import com.server.hr.model.LeaveType;
import com.server.hr.service.LeaveTypeService;

@RestController
@RequestMapping("/employee")

public class LeaveTypeResource {
	private final LeaveTypeService leaveTypeService;

	public LeaveTypeResource(LeaveTypeService leaveTypeService) {

		this.leaveTypeService = leaveTypeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<LeaveType>> getAllLeaveType() {
		List<LeaveType> employees = leaveTypeService.findAllLeaveType();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/listArchived")
	public ResponseEntity<List<LeaveType>> getArchivedLeaveTypes() {
		List<LeaveType> employees = leaveTypeService.getLeaveTypesByIsArchived(true);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/listActivated")
	public ResponseEntity<List<LeaveType>> getActivatedLeaveTypes() {
		List<LeaveType> employees = leaveTypeService.getLeaveTypesByIsArchived(false);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PutMapping("/archive/{id}")
	public ResponseEntity<String> changeStatusLeaveType(@PathVariable("id") Long id) {
		leaveTypeService.changeLeaveTypeStatus(id);
		return new ResponseEntity<String>("LeaveType status changed successfully !!!", HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable("id") Long id) {
		LeaveType employee = leaveTypeService.findLeaveTypeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<LeaveType> addLeaveType(@RequestBody LeaveType employee) {
		LeaveType newemployee = leaveTypeService.addLeaveType(employee);
		return new ResponseEntity<>(newemployee, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<LeaveType> updateLeaveType(@RequestBody LeaveType employee) {
		LeaveType updateemployee = leaveTypeService.updateLeaveType(employee);
		return new ResponseEntity<>(updateemployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLeaveType(@PathVariable("id") Long id) {
		leaveTypeService.deleteLeaveType(id);
		return new ResponseEntity<String>("LeaveType is deleted successfully !!!", HttpStatus.OK);
	}

}
