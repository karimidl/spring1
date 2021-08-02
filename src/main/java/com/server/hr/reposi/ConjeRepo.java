package com.server.hr.reposi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.server.hr.model.Leave;


public interface ConjeRepo extends JpaRepository<Leave,Long>{
	
	
	  Optional<Leave> findConjeById(Long id);
	  void deleteConjeById(Long id);
	 @Query(value = "SELECT * FROM conje WHERE employee_id= ?1", nativeQuery = true)
	  List <Leave> findCongeEmployeeById(Long id);


}
