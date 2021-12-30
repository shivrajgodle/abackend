package com.anemoi.api.controller;

import com.anemoi.api.exception.ResourceNotFoundException;
import com.anemoi.api.model.Client;
import com.anemoi.api.model.TeamMember;
import com.anemoi.api.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import javax.validation.Valid;

@RestController
public class GenRowController {

	/*
    @GetMapping("/clients/{objId}")
    public Client getObject(@PathVariable Long objId) {
		Optional<Client> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Client not found with id " + objId);
		return p.get();
    }

    
    @GetMapping("/clients")
    public Page<GenRow> getObjects(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @PostMapping("/clients")
    public GenRow createOject(@Valid @RequestBody Client client) {
        return repository.save(client);
    }
    

    @PutMapping("/clients/{objId}")
    public Client updateObject(@PathVariable Long objId,
                                   @Valid @RequestBody Client request) {
    	
        	
        return repository.findById(objId)
                .map(obj -> 
                	{
                		obj.setApprover(request.getApprover()); 
                		obj.setCompanyName(request.getCompanyName());
                		obj.setGroupCompany(request.getGroupCompany());
                		obj.setPan(request.getPan());
                		obj.setTan(request.getTan());
                		obj.setPrecisionId(request.getPrecisionId());
                		obj.setStatus(request.isStatus());
                	
                    return repository.save(obj);
                	}
                )
                .orElseThrow( () -> new ResourceNotFoundException("Client not found with id " + objId) );
    }


    @DeleteMapping("/clients/{objId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long objId) {
        return repository.findById(objId)
                .map(obj -> {
                    repository.delete(obj);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + objId));
    }
    
    */
}
