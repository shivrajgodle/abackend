package com.anemoi.api.controller;

import com.anemoi.api.exception.ResourceNotFoundException;
import com.anemoi.api.model.Document;
import com.anemoi.api.model.Project;
import com.anemoi.api.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.Optional;

import javax.validation.Valid;

@RestController
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    @GetMapping("/documents")
    public Page<Document> getQuestions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/documents/{objId}")
    public Document getObject(@PathVariable Long objId) {
		Optional<Document> p =  repository.findById(objId);        
		if(!p.isPresent())	throw new ResourceNotFoundException("Document not found with id " + objId);
		return p.get();
    }


    @PostMapping("/documents")
    public Document createQuestion(@Valid @RequestBody Document Document) {
        return repository.save(Document);
    }
    

    @PutMapping("/documents/{id}")
    public Document updateQuestion(@PathVariable Long id,
                                   @Valid @RequestBody Document request) {
        return repository.findById(id)
                .map(document -> {
                	                	
                	document.setClientSpecific(request.isClientSpecific());
                	document.setDocType(request.getDocType());
                	document.setFileURL(request.getFileURL());
                	document.setDescription(request.getDescription());
                	document.setStatus(request.getStatus());	
                	
                    
                    return repository.save(document);
                }).orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + id));
    }


    @DeleteMapping("/documents/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        return repository.findById(id)
                .map(document -> {
                	repository.delete(document);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + id));
    }
}
