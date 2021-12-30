package com.anemoi.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "projectteam")
public class ProjectTeam extends TrailModel implements Serializable
	{
    @Id
    @GeneratedValue(generator = "pteam_generator")
    @SequenceGenerator(
            name = "pteam_generator",
            sequenceName = "pteam_sequence",
            initialValue = 8000
    		)    
    private long teamMemberId;
    private long projectId;
    private String projectRole ;
    private String auditorId ;
	public long getTeamMemberId() {
		return teamMemberId;
	}
	public void setTeamMemberId(long teamMemberId) {
		this.teamMemberId = teamMemberId;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	public String getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	
	
	
	
	}