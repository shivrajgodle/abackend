package com.anemoi.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "auditor")
public class Auditor extends TrailModel implements Serializable
	{
    
    @Id
    private String email ;    
    private String name;
    private String contact;
    private String linedInPRofile;
    private String role ;    
    private int experiance ;

    private String pastClients ;

    private String expertise ;
    
    private String departmentName ;
    
    private String location ;
    
    private String reportingTo ;
    
	private String data1 ;
	
	private String data2 ;
    
	private String data3 ;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLinedInPRofile() {
		return linedInPRofile;
	}

	public void setLinedInPRofile(String linedInPRofile) {
		this.linedInPRofile = linedInPRofile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

	public String getPastClients() {
		return pastClients;
	}

	public void setPastClients(String pastClients) {
		this.pastClients = pastClients;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
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

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}
    
    
	
    
	}    
