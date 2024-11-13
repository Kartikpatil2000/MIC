package com.cdac.Project.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Project.dao.ComplaintRepository;
import com.cdac.Project.entities.Complaint;

@Service
public class ComplaintService {
	@Autowired
	private ComplaintRepository complaintRepository;
	
	public Complaint addComplaint(Complaint complaint)
	{
		return complaintRepository.save(complaint);
	}
	
	public void updateComplaint(Complaint complaint, int complaintId)
	{
		complaint.setComplaintId(complaintId);
		complaintRepository.save(complaint);
	}
	
	public Complaint getComplaint(int id)
	{
		Optional<Complaint> optional= complaintRepository.findById(id);
		Complaint complaint=optional.get();
		return complaint;
	}
	
	public List<Complaint> getAllUsers()
	{
		List <Complaint> lists = (List<Complaint>) complaintRepository.findAll();
		return  lists;
	}
	
	public List<Complaint> getComplaintByStatus(String status)
	{
		List <Complaint> complaints = complaintRepository.findByStatus(status);
		return complaints;
	}
		
	public List<Complaint> getUsersByLocation(String location)
	{
		List <Complaint> complaints = complaintRepository.findByLocation(location);
		return complaints;
	}
	
}
