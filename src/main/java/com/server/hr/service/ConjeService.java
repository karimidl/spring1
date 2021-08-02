package com.server.hr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.hr.exceptions.CongeEmployeeNotFoundExcep;
import com.server.hr.exceptions.ConjeNotFoundException;
import com.server.hr.model.Leave;

import com.server.hr.reposi.ConjeRepo;

@Service
@Transactional
public class ConjeService {
	private final ConjeRepo conjeRepo;
	
	
	
	@Autowired
	public ConjeService (ConjeRepo conjeRepo) {
		this.conjeRepo=conjeRepo;
	}
	
	public Leave addConje(Leave conje) {
		return conjeRepo.save(conje);
	}
	public List<Leave> findAllConje(){
		return conjeRepo.findAll();
	}
	
	public Leave UpdateConje(Leave conje) {
		return conjeRepo.save(conje);
	}
	
    public Leave findConjeById(Long id_c) {
    	return conjeRepo.findConjeById(id_c).orElseThrow(()-> new ConjeNotFoundException("conje N°" +id_c+ "pas trouvé"));
    }
    public List<Leave> findcongeEmployee(Long id_e) {
    	return conjeRepo.findCongeEmployeeById(id_e);
    }
    public void deleteConjeById(Long id_c) {
    	 conjeRepo.deleteConjeById(id_c);
    }
}
