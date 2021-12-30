package com.anemoi.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "risk_control")
public class AuditEntry extends TrailModel implements Serializable
	{
    
    @Id
    @GeneratedValue(generator = "riskcontrol_generator")
    @SequenceGenerator(
            name = "riskcontrol_generator",
            sequenceName = "riskcontrol_sequence",
            initialValue = 5000
    		) 
    
    private long auditEntry ;
    
    private long projectId ;
    
    private String department ;
    
    private String process;
    
    private String subprocess;

    private String location ;
    
    private String auditor ;
    
    private String auditorId  ;
    
    
    private int plannedDays ;

    private Date plannedStart ;
    
    private Date plannedEnd ;

    
    private int actualsDays ;

    private Date actualStart ;
    
    private Date actualEnd ;

    
    private String status ;
      
	}    
