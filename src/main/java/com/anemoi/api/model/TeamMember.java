package com.anemoi.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "team_member")
public class TeamMember extends TrailModel implements Serializable
	{
    
    @Id
    @GeneratedValue(generator = "teammember_generator")
    @SequenceGenerator(
            name = "teammember_generator",
            sequenceName = "teammember_sequence",
            initialValue = 3000
    		) 
    private long memberId ;
    
    private String name;

    private String contact;

    private String role ;
    
    private String departmentName ;
    
    private String location ;

    private String email;
    
    private String reportingTo ;
    
    private long cliendId ;
    
    private long projectId ;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public long getCliendId() {
		return cliendId;
	}

	public void setCliendId(long cliendId) {
		this.cliendId = cliendId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	
    
    
	
    
	}    
