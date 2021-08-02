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

import com.server.hr.model.Department;

import com.server.hr.service.DepService;



@RestController
@RequestMapping("/department")
public class DepResource {
	
	public final DepService depService;
	
	public DepResource(DepService depService) {
		this.depService=depService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAlldep(){
		List<Department> dep=depService.findAllDep();
		return new ResponseEntity<>(dep,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Department> getDepById(@PathVariable("id") Long id){
		Department dep=depService.findDepById(id);
		return new ResponseEntity<>(dep,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Department> addDep(@RequestBody Department dep){
		Department newdep=depService.addDep(dep);
		return new ResponseEntity<>(dep,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Department> updateDep(@RequestBody Department dep){
		Department updatedep=depService.updateDep(dep);
		return new ResponseEntity<>(dep,HttpStatus.OK);
	}
	/*@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletedep(@PathVariable("id") Long id){
		 depService.deleteDepById(id);
		return new ResponseEntity<String>("Departement supprimer avec succees!! ",HttpStatus.OK);
	}*/
	
	

}
