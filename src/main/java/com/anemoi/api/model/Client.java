package com.anemoi.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client extends TrailModel implements Serializable {

    @Id
    @GeneratedValue(generator = "client_generator")
    @SequenceGenerator(
            name = "client_generator",
            sequenceName = "client_sequence",
            initialValue = 100000
    		)    
    private Long id;

    @NotBlank
    @Size(min = 3, max = 200)
    private String legalName;

    private String groupCompany ;

    private String ownershipNature ;

    private String industry ;
    
    private String sector ;

    private String clientContact1 ;

    private String clientContact2 ;

    private String clientContact3 ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getGroupCompany() {
		return groupCompany;
	}

	public void setGroupCompany(String groupCompany) {
		this.groupCompany = groupCompany;
	}

	public String getOwnershipNature() {
		return ownershipNature;
	}

	public void setOwnershipNature(String ownershipNature) {
		this.ownershipNature = ownershipNature;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getClientContact1() {
		return clientContact1;
	}

	public void setClientContact1(String clientContact1) {
		this.clientContact1 = clientContact1;
	}

	public String getClientContact2() {
		return clientContact2;
	}

	public void setClientContact2(String clientContact2) {
		this.clientContact2 = clientContact2;
	}

	public String getClientContact3() {
		return clientContact3;
	}

	public void setClientContact3(String clientContact3) {
		this.clientContact3 = clientContact3;
	}

    
    
    
}
