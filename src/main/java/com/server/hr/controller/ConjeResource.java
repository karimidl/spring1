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

import com.server.hr.model.Leave;

import com.server.hr.service.ConjeService;

@RestController
@RequestMapping("/conje")
public class ConjeResource {
	private final ConjeService conjeService;

	public ConjeResource(ConjeService conjeService) {
		this.conjeService=conjeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Leave>> getAllConje(){
		List<Leave> conje=conjeService.findAllConje();
		return new ResponseEntity<>(conje,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Leave> getConjeById(@PathVariable("id") Long id){
		Leave conje=conjeService.findConjeById(id);
		return new ResponseEntity<>(conje,HttpStatus.OK);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<List<Leave>> getCongeEmployeeById(@PathVariable("id") Long id){
		List<Leave> conge=conjeService.findcongeEmployee(id);
		return new ResponseEntity<>(conge,HttpStatus.OK);
	}
    @PostMapping("/add")
    public ResponseEntity<Leave> addConje(@RequestBody Leave conje){
        Leave newconje=conjeService.addConje(conje); 
    	return new ResponseEntity<>(newconje,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Leave> updateConje(@RequestBody Leave conje){
    	Leave updateconje=conjeService.UpdateConje(conje);
    	return new ResponseEntity<>(updateconje,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id_c}")
    public ResponseEntity<String> deleteConje(@PathVariable("id_c") Long id_c){
		conjeService.deleteConjeById(id_c);
		return new ResponseEntity<String>("Conje is deleted successfully !!!",HttpStatus.OK);
	}
}
