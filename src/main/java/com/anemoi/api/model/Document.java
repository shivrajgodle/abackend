package com.anemoi.api.model;

import java.net.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "documents")
public class Document extends TrailModel {

	@Id
    @GeneratedValue(generator = "docid_generator")
    @SequenceGenerator(
            name = "docid_generator",
            sequenceName = "docid_sequence",
            initialValue = 20000
    		)
		
	private Long id;

	private boolean clientSpecific ;
	
	private Long projectId ;
	
	private String docType ;

	private String fileFormat ;
	
	private URL fileURL ;
	
	private String description ;
		
	private String status ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isClientSpecific() {
		return clientSpecific;
	}

	public void setClientSpecific(boolean clientSpecific) {
		this.clientSpecific = clientSpecific;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public URL getFileURL() {
		return fileURL;
	}

	public void setFileURL(URL fileURL) {
		this.fileURL = fileURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}
