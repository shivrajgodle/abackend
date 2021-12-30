package com.anemoi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anemoi.api.model.Auditor;
import com.anemoi.api.model.Client;

import java.util.List;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, String> {
}
