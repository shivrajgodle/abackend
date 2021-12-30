package com.anemoi.api.controller;

import com.anemoi.api.exception.ResourceNotFoundException;
import com.anemoi.api.model.Client;
import com.anemoi.api.model.Project;
import com.anemoi.api.model.ProjectTeam;
import com.anemoi.api.model.EscalationRule;
import com.anemoi.api.repository.ClientRepository;
import com.anemoi.api.repository.EscalationRuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
public class EscalationRuleController {

	@Autowired
	private EscalationRuleRepository repository;

	@GetMapping("/escrule/{objId}")
	public EscalationRule getObject(@PathVariable Long objId) {
		Optional<EscalationRule> p = repository.findById(objId);
		if (!p.isPresent())
			throw new ResourceNotFoundException("Escalation Rule not found with id " + objId);
		return p.get();
	}

	@GetMapping("/escrule/all/{objId}")
	public List<EscalationRule> getProjectTeamsByProjectId(@PathVariable Long objId) {
		return repository.findByProjectId(objId);
	}

	@GetMapping("/escrule")
	public Page<EscalationRule> getObjects(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@PostMapping("/escrule")
	public EscalationRule createOject(@Valid @RequestBody EscalationRule obj) {
		return repository.save(obj);
	}

	@PutMapping("/escrule/{objId}")
	public EscalationRule updateObject(@PathVariable Long objId, @Valid @RequestBody EscalationRule request) {

		Optional<EscalationRule> p = repository.findById(objId);
		if (!p.isPresent())
			throw new ResourceNotFoundException("Escalation Rule not found with id " + objId);

		EscalationRule pdest = p.get();

		if (request.getProjectId() != null)
			pdest.setProjectId(request.getProjectId());
		if (request.getTrigger() != null)
			pdest.setTrigger(request.getTrigger());
		if (request.getLevel() != null)
			pdest.setLevel(request.getLevel());
		if (request.getEscalationIds() != null)
			pdest.setEscalationIds(request.getEscalationIds());
		if (request.getNoDaysNoResponse() != 0)
			pdest.setNoDaysNoResponse(request.getNoDaysNoResponse());
		if (request.getReminderPeriod1() != 0)
			pdest.setReminderPeriod1(request.getReminderPeriod1());
		if (request.getReminderPeriod2() != 0)
			pdest.setReminderPeriod2(request.getReminderPeriod2());
		if (request.getReminderPeriod3() != 0)
			pdest.setReminderPeriod3(request.getReminderPeriod3());
		if (request.getReminderIds1() != null)
			pdest.setReminderIds1(request.getReminderIds1());
		if (request.getReminderIds2() != null)
			pdest.setReminderIds2(request.getReminderIds2());
		if (request.getReminderIds3() != null)
			pdest.setReminderIds3(request.getReminderIds3());

		
		if (request.getTemplateEscalation() != null)
			pdest.setTemplateEscalation(request.getTemplateEscalation());

		if (request.getTemplateReminder() != null)
			pdest.setTemplateReminder(request.getTemplateReminder());

		
		if (request.getScope() != null)
			pdest.setScope(request.getScope());
		if (request.getEntityIdNum() != null)
			pdest.setEntityIdNum(request.getEntityIdNum());
		if (request.getEntityIdStr() != null)
			pdest.setEntityIdStr(request.getEntityIdStr());

		this.repository.save(pdest);
		return pdest;
	}

	@DeleteMapping("/escrule/{objId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long objId) {
		return repository.findById(objId).map(obj -> {
			repository.delete(obj);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Escalation Rule not found with id " + objId));
	}
}
