package com.cdac.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Project.entities.Complaint;
import com.cdac.Project.resources.ComplaintService;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
	
	
	@Autowired
	ComplaintService complaintService;
	@PostMapping("/addComplaint")
	public ResponseEntity <Complaint> addUser(@RequestBody Complaint complaint) {
		Complaint comp = null;
		
		try {
			comp= this.complaintService.addComplaint(complaint);
			System.out.println(comp);
			return ResponseEntity.status(HttpStatus.CREATED).body(comp);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getComplaint/{ComplaintId}")
	public ResponseEntity<Complaint> getComplaint(@PathVariable("ComplaintId") int id) {
		Complaint comp=complaintService.getComplaint(id);
		if(comp==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(comp); 
	}
	
	@GetMapping("/getComplaintsByLocation")
	public ResponseEntity<List<Complaint>> getComplaintByLocation(@PathVariable("location") String location){
		List <Complaint> list= complaintService.getUsersByLocation(location);
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/getComplaintsByStatus")
	public ResponseEntity<List<Complaint>> getComplaintByStatus(@PathVariable("Status") String Status){
		List <Complaint> list= complaintService.getUsersByLocation(Status);
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	

}
