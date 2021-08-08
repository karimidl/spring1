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
@RequestMapping("/leaveType")

public class LeaveTypeResource {
	private final LeaveTypeService leaveTypeService;

	public LeaveTypeResource(LeaveTypeService leaveTypeService) {

		this.leaveTypeService = leaveTypeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<LeaveType>> getAllLeaveType() {
		List<LeaveType> leaveTypes = leaveTypeService.findAllLeaveType();
		return new ResponseEntity<>(leaveTypes, HttpStatus.OK);
	}

	
	/*@PutMapping("/archive/{id}")
	public ResponseEntity<String> changeStatusLeaveType(@PathVariable("id") Long id) {
		leaveTypeService.changeLeaveTypeStatus(id);
		return new ResponseEntity<String>("LeaveType status changed successfully !!!", HttpStatus.OK);
	}*/

	@GetMapping("/find/{id}")
	public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable("id") Long id) {
		LeaveType leaveType = leaveTypeService.findLeaveTypeById(id);
		return new ResponseEntity<>(leaveType, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<LeaveType> addLeaveType(@RequestBody LeaveType leaveType) {
		LeaveType newleaveType = leaveTypeService.addLeaveType(leaveType);
		return new ResponseEntity<>(newleaveType, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<LeaveType> updateLeaveType(@RequestBody LeaveType leaveType) {
		LeaveType updateleaveType = leaveTypeService.updateLeaveType(leaveType);
		return new ResponseEntity<>(updateleaveType, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLeaveType(@PathVariable("id") Long id) {
		leaveTypeService.deleteLeaveType(id);
		return new ResponseEntity<String>("LeaveType is deleted successfully !!!", HttpStatus.OK);
	}

}
