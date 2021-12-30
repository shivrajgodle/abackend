package com.anemoi.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "risk_control")
public class RiskControl extends TrailModel implements Serializable
	{
    
    @Id
    @GeneratedValue(generator = "riskcontrol_generator")
    @SequenceGenerator(
            name = "riskcontrol_generator",
            sequenceName = "riskcontrol_sequence",
            initialValue = 5000
    		) 
    
    private long controlId ;    
    
    private long clientId ;
    
    private String process;
    
    private String subprocess;

    private String risk ;
    
    private String control ;

    private String nature ;
    
    private int frequency ;
    
    private String description ;

	public long getControlId() {
		return controlId;
	}

	public void setControlId(long controlId) {
		this.controlId = controlId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getSubprocess() {
		return subprocess;
	}

	public void setSubprocess(String subprocess) {
		this.subprocess = subprocess;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


    
    
    
    
    
    
	}    
