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
import com.anemoi.api.model.Project;
import com.anemoi.api.repository.ProjectRepository;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository repository;
    
    
    @GetMapping("/projects/{objId}")
    public Project getObject(@PathVariable Long objId) {
		Optional<Project> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Team member not found with id " + objId);
		return p.get();
    }
       
    @GetMapping("/projects")
    public Page<Project> getProjectsByProjectId(Pageable pageable) {
        return repository.findAll(pageable);
    	}

    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project project) 
    	{
        return repository.save(project);
    	}
    
    @PutMapping("/projects/{projectId}")
    public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project request) 
    	{
    	Optional<Project> p =  repository.findById(projectId);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Project not found with id " + projectId);
        
    	Project pdest = p.get();
    	
    	
    	pdest.setProjectCode(request.getProjectCode());
    	pdest.setTaskCode( request.getTaskCode());
    	pdest.setClientId(request.getClientId());
    	pdest.setBillingCode(request.getBillingCode());
    	pdest.setAnnualYear(request.getAnnualYear());
    	pdest.setDeactivatonDate(request.getDeactivatonDate());
    	pdest.setGracePeriod(request.getGracePeriod());
    	pdest.setActivatonDate(request.getActivatonDate());
    	pdest.setActivity(request.getActivity());
    	pdest.setProjectDescription(request.getProjectDescription());

    	
 
    	
    	
    	this.repository.save(pdest);
    	return pdest ;
    	}

    
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) 
    	{
    	Optional<Project> p =  repository.findById(projectId);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Deletion : Project not found with id " + projectId);   	
    	repository.delete(p.get());
        return ResponseEntity.ok().build();    	
    	}
    
	}
