package com.anemoi.api.controller;

import com.anemoi.api.exception.ResourceNotFoundException;
import com.anemoi.api.model.Client;
import com.anemoi.api.model.Project;
import com.anemoi.api.model.TeamMember;
import com.anemoi.api.repository.ClientRepository;
import com.anemoi.api.repository.TeamMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import javax.validation.Valid;

@RestController
public class TeamMemberController {

    @Autowired
    private TeamMemberRepository repository;

    @GetMapping("/members/{objId}")
    public TeamMember getObject(@PathVariable Long objId) {
		Optional<TeamMember> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Team member not found with id " + objId);
		return p.get();
    }
    
    @GetMapping("/members")
    public Page<TeamMember> getObjects(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @PostMapping("/members")
    public TeamMember createOject(@Valid @RequestBody TeamMember obj) {
        return repository.save(obj);
    }
    

    @PutMapping("/members/{objId}")
    public TeamMember updateObject(@PathVariable Long objId,
                                   @Valid @RequestBody TeamMember request) {
    	
    	Optional<TeamMember> p =  repository.findById(objId);        
    	if(!p.isPresent())	throw new ResourceNotFoundException("Team member not found with id " + objId);
        
     	TeamMember pdest = p.get();
     	pdest.setEmail(request.getEmail());
    	pdest.setName(request.getName());
    	pdest.setReportingTo(request.getReportingTo());
    	
    	this.repository.save(pdest);
    	return pdest ;
    }


    @DeleteMapping("/members/{objId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long objId) {
        return repository.findById(objId)
                .map(obj -> {
                    repository.delete(obj);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Team member not found with id " + objId));
    }
}
