package com.server.hr.reposi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.hr.model.Department;

public interface DepRepo extends JpaRepository<Department,Long>{
	  Optional<Department> findDepById(Long id);
	  
	//  void DeleteDepById(Long id);

}
