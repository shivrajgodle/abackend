package com.anemoi.api.controller;

import java.util.Date;
import java.util.List;
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
import com.anemoi.api.model.EmailTemplate;
import com.anemoi.api.repository.EmailTemplateRepository;

@RestController
public class EmailTemplateController {

    @Autowired
    private EmailTemplateRepository repository;

    
    @GetMapping("/etemplates/{objId}")
    public EmailTemplate getObject(@PathVariable Long objId) {
		Optional<EmailTemplate> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Get : EmailTemplate not found with id " + objId);
		return p.get();
    }

    @GetMapping("/etemplates/all/{objId}")
    public List<EmailTemplate> getEmailTemplatesByProjectId(@PathVariable Long objId) {
        return repository.findByProjectId(objId);
    	}
    
    
    @GetMapping("/etemplates")
    public Page<EmailTemplate> getEmailTemplatesByEmailTemplateId(Pageable pageable) {
        return repository.findAll(pageable);
    	}

    @PostMapping("/etemplates")
    public EmailTemplate createEmailTemplate(@Valid @RequestBody EmailTemplate tmemberid) 
    	{
        return repository.save(tmemberid);
    	}
    
    @PutMapping("/etemplates/{tmemberid}")
    public EmailTemplate updateEmailTemplate(@PathVariable Long tmemberid, @Valid @RequestBody EmailTemplate request) 
    	{
    	Optional<EmailTemplate> p =  repository.findById(tmemberid);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Updations : EmailTemplate not found with id " + tmemberid);
        
    	EmailTemplate pdest = p.get();
        
    	if(request.getTemplateName() !=null) pdest.setTemplateName(request.getTemplateName());
    	if(request.getProjectId() !=0)	pdest.setProjectId(request.getProjectId());
    	if(request.getCcList() !=null) pdest.setCcList(request.getCcList());
    	if(request.getToList() !=null) pdest.setToList(request.getToList());
    	if(request.getBccList() !=null) pdest.setBccList(request.getBccList());
    	if(request.getEmailSubject() !=null) pdest.setEmailSubject(request.getEmailSubject());
    	if(request.getEmailBody() !=null) pdest.setEmailBody(request.getEmailBody());
    	if(request.getVariables() !=null) pdest.setVariables(request.getVariables());
    	       
    	this.repository.save(pdest);
    	return pdest ;
    	}

    
    @DeleteMapping("/etemplates/{tmemberid}")
    public ResponseEntity<?> deleteEmailTemplate(@PathVariable Long tmemberid) 
    	{
    	Optional<EmailTemplate> p =  repository.findById(tmemberid);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Deletion : EmailTemplate not found with id " + tmemberid);   	
    	repository.delete(p.get());
        return ResponseEntity.ok().build();    	
    	}
    
	}
