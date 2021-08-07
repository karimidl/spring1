package com.server.hr.reposi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.hr.model.LeaveType;

public interface LeaveTypeRepo extends JpaRepository<LeaveType, Long>{

	void deleteLeaveTypeById(Long id);

  Optional<LeaveType> findLeaveTypeById(Long id);

  List<LeaveType> getLeaveTypeByIsArchived(Boolean isArchived);

}
