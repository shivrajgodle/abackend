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
import com.anemoi.api.model.ProjectTeam;
import com.anemoi.api.repository.ProjectTeamRepository;

@RestController
public class ProjectTeamController {

    @Autowired
    private ProjectTeamRepository repository;

    
    @GetMapping("/projectteam/{objId}")
    public ProjectTeam getObject(@PathVariable Long objId) {
		Optional<ProjectTeam> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Get : ProjectTeam not found with id " + objId);
		return p.get();
    }

    @GetMapping("/projectteam/all/{objId}")
    public List<ProjectTeam> getProjectTeamsByProjectId(@PathVariable Long objId) {
        return repository.findByProjectId(objId);
    	}
    
    
    @GetMapping("/projectteam")
    public Page<ProjectTeam> getProjectTeamsByProjectTeamId(Pageable pageable) {
        return repository.findAll(pageable);
    	}

    @PostMapping("/projectteam")
    public ProjectTeam createProjectTeam(@Valid @RequestBody ProjectTeam tmemberid) 
    	{
        return repository.save(tmemberid);
    	}
    
    @PutMapping("/projectteam/{tmemberid}")
    public ProjectTeam updateProjectTeam(@PathVariable Long tmemberid, @Valid @RequestBody ProjectTeam request) 
    	{
    	Optional<ProjectTeam> p =  repository.findById(tmemberid);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Updations : ProjectTeam not found with id " + tmemberid);
        
    	ProjectTeam pdest = p.get();
        
       if(request.getProjectId() != 0) pdest.setProjectId(request.getProjectId());
       if(request.getProjectRole() != null) pdest.setProjectRole(request.getProjectRole());
       if(request.getAuditorId() !=null)  pdest.setAuditorId(request.getAuditorId());

    	this.repository.save(pdest);
    	return pdest ;
    	}

    
    @DeleteMapping("/projectteam/{tmemberid}")
    public ResponseEntity<?> deleteProjectTeam(@PathVariable Long tmemberid) 
    	{
    	Optional<ProjectTeam> p =  repository.findById(tmemberid);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Deletion : ProjectTeam not found with id " + tmemberid);   	
    	repository.delete(p.get());
        return ResponseEntity.ok().build();    	
    	}
    
	}
