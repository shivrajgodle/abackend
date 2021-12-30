package com.anemoi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anemoi.api.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
