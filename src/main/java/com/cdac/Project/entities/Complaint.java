package com.cdac.Project.entities;

import java.util.Objects;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "complaint_details")
@CrossOrigin("*")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int complaintId; // Consistent naming

    @Column
    private int userId; // Removed @Transient

    @Column(name="location")
    private String location;

    @Column(name="complaint_type")
    private String complaintType;

    @Column(name="complaint")
    private String complaint;

    @Column(name="status")
    private String status;

    public Complaint() {
        // Default constructor
    }

    public Complaint(String location, String complaintType, String complaint, byte[] image) {
        this.location = location;
        this.complaintType = complaintType;
        this.complaint = complaint;
      
    }

    // Getters and Setters
    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

   

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", userId=" + userId + ", location=" + location
				+ ", complaintType=" + complaintType + ", complaint=" + complaint + ", status=" + status + "]";
	}

    @Override
	public int hashCode() {
		return Objects.hash(complaint, complaintId, complaintType, location, status, userId);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complaint other = (Complaint) obj;
		return Objects.equals(complaint, other.complaint) && complaintId == other.complaintId
				&& Objects.equals(complaintType, other.complaintType) && Objects.equals(location, other.location)
				&& Objects.equals(status, other.status) && userId == other.userId;
	}
}
