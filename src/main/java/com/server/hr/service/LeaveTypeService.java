package com.server.hr.service;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.exceptions.LeaveTypeNotFoundException;
import com.server.hr.exceptions.UserNotFoundException;
import com.server.hr.model.Employee;
import com.server.hr.model.Leave;
import com.server.hr.model.LeaveType;
import com.server.hr.reposi.LeaveTypeRepo;



@Service
@Transactional
public class LeaveTypeService {
	private final LeaveTypeRepo leaveTypeRepo;

	@Autowired
	public LeaveTypeService(LeaveTypeRepo leaveTypeRepo) {
		
		this.leaveTypeRepo = leaveTypeRepo;
	}
	public LeaveType addLeaveType(LeaveType leaveType) {
		
		return leaveTypeRepo.save(leaveType);
	}
	public List<LeaveType> findAllLeaveType(){
		return leaveTypeRepo.findAll();
	}
	public LeaveType updateLeaveType(LeaveType leaveType) {
		return leaveTypeRepo.save(leaveType);
	}
	/*public List<LeaveType> getLeaveTypesByIsArchived(Boolean isArchived) {
		return leaveTypeRepo.getLeaveTypeByIsArchived(isArchived);
	}*/
	/*public void changeLeaveTypeStatus(Long id) {
		LeaveType leaveType = this.findLeaveTypeById(id);
		leaveType.setIsArchived(!leaveType.getIsArchived());
	}*/
	public LeaveType findLeaveTypeById(Long id) {
		return leaveTypeRepo.findLeaveTypeById(id).orElseThrow(()-> new LeaveTypeNotFoundException("Leave Type N°" +id+ "pas trouvé"));
	}
	public void deleteLeaveType(Long id) {
		leaveTypeRepo.deleteLeaveTypeById(id);
	}
	

}
