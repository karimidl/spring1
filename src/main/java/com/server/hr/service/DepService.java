package com.server.hr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.exceptions.DepNotFoundException;
import com.server.hr.model.Department;
import com.server.hr.reposi.DepRepo;

@Service
@Transactional
public class DepService {
	
	public final DepRepo depRepo;
	
	
	@Autowired
	public DepService(DepRepo depRepo) {
		this.depRepo=depRepo;
	}
	 
	public Department addDep(Department dep) {
		return depRepo.save(dep);
	}
	public Department updateDep(Department dep) {
		return depRepo.save(dep);
	}
	public Department findDepById(Long id) {
		return depRepo.findDepById(id).orElseThrow(()-> new DepNotFoundException("dep num :"+id+"not found"));
		
	}
	public List<Department>findAllDep() {
		return depRepo.findAll();
	}
	/*public void deleteDepById(Long id) {
		 depRepo.DeleteDepById(id);
	}*/

}
