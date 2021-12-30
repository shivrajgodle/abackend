package com.anemoi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anemoi.api.model.Auditor;
import com.anemoi.api.model.Client;
import com.anemoi.api.model.EscalationRule;
import com.anemoi.api.model.ProjectTeam;

import java.util.List;

@Repository
public interface EscalationRuleRepository extends JpaRepository<EscalationRule, Long> {	
	List<EscalationRule> findByProjectId(Long name);
}
