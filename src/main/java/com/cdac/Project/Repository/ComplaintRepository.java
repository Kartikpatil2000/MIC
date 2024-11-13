package com.cdac.Project.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cdac.Project.entities.Complaint;

public interface ComplaintRepository extends CrudRepository<Complaint, Integer>{

	List<Complaint> findByStatus(String status);

	List<Complaint> findByLocation(String location);

		
}
