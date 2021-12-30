package com.anemoi.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "data_request")
public class DataRequest extends TrailModel implements Serializable
	{
    
    @Id
    @GeneratedValue(generator = "riskcontrol_generator")
    @SequenceGenerator(
            			name = "riskcontrol_generator",
            			sequenceName = "riskcontrol_sequence",
            			initialValue = 5000
    					) 
    private long requestId ;
    
    private long projectId ;
   
    
    
    private long controlId ;
    
    private long auditEntryId ;
    
    private String assignedTo ;
    
    private Date deadline ;

    private String status ;
    
    private String dataName ;
    
    private String description ;
    
	}    
