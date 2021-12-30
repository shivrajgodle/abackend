package com.anemoi.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anemoi.api.model.EmailTemplate;
import com.anemoi.api.model.Project;
import com.anemoi.api.model.ProjectTeam;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
	List<EmailTemplate> findByProjectId(Long name);
}
