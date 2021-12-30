package com.anemoi.api.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anemoi.api.exception.ResourceNotFoundException;
import com.anemoi.api.model.Auditor;
import com.anemoi.api.repository.AuditorRepository;

@RestController
public class AuditorController {

    @Autowired
    private AuditorRepository repository;
    
    
    @GetMapping("/auditors/{objId}")
    public Auditor getObject(@PathVariable String objId) {
		Optional<Auditor> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Get : Auditor not found with id " + objId);
		return p.get();
    }
       
    @GetMapping("/auditors")
    public Page<Auditor> getAuditorsByAuditorId(Pageable pageable) {
        return repository.findAll(pageable);
    	}

    @PostMapping("/auditors")
    public Auditor createAuditor(@Valid @RequestBody Auditor auditor) 
    	{
        return repository.save(auditor);
    	}
    
    @PutMapping("/auditors/{auditorId}")
    public Auditor updateAuditor(@PathVariable String auditorId, @Valid @RequestBody Auditor request) 
    	{
    	Optional<Auditor> p =  repository.findById(auditorId);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Updations : Auditor not found with id " + auditorId);
        
    	Auditor pdest = p.get();
    	
    	if(request.getName()!=null) pdest.setName(request.getName());
    	if(request.getContact()!=null)pdest.setContact(request.getContact());
    	if(request.getDepartmentName()!=null) pdest.setDepartmentName(request.getDepartmentName());
    	if(request.getLinedInPRofile()!=null)pdest.setLinedInPRofile(request.getLinedInPRofile());
    	if(request.getPastClients()!=null) pdest.setPastClients(request.getPastClients());
    	if(request.getRole()!=null)pdest.setRole(request.getRole());
    	if(request.getLocation()!=null)	pdest.setLocation(request.getLocation());
    	if(request.getRole()!=null)pdest.setRole(request.getRole());
    	if(request.getExperiance() != 0) pdest.setExperiance(request.getExperiance());
    	if(request.getReportingTo()!=null)	pdest.setReportingTo(request.getReportingTo());
    	if(request.getData1()!=null)		pdest.setData1(request.getData1());
    	if(request.getData2()!=null)		pdest.setData2(request.getData2());
    	if(request.getData3()!=null)		pdest.setData3(request.getData3());
    	if(request.getExpertise()!=null)	pdest.setExpertise(request.getExpertise());
    	    	
    	
    	this.repository.save(pdest);
    	return pdest ;
    	}

    
    @DeleteMapping("/auditors/{auditorId}")
    public ResponseEntity<?> deleteAuditor(@PathVariable String auditorId) 
    	{
    	Optional<Auditor> p =  repository.findById(auditorId);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Deletion : Auditor not found with id " + auditorId);   	
    	repository.delete(p.get());
        return ResponseEntity.ok().build();    	
    	}
    
	}
