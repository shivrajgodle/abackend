package com.anemoi.api.model;

import java.net.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "escrules")
public class EscalationRule extends TrailModel {

	@Id
    @GeneratedValue(generator = "esclation_generator")
    @SequenceGenerator(
            name = "escalation_generator",
            sequenceName = "escalation_sequence",
            initialValue = 20000
    		)
	private Long id;

	private Long projectId ;
	
	private String trigger  ;
	
	private String level ;
		
	
	private String escalationIds ;
	
	private int noDaysNoResponse ;

	
	private int reminderPeriod1 ;

	private String reminderIds1 ;
	
	
	private int reminderPeriod2 ;

	private String reminderIds2 ;
	
	
	private int reminderPeriod3 ;

	private String reminderIds3 ;

	
	private String templateEscalation ;
	
	private String templateReminder ;

	private String scope ;
	
	private String entityIdStr ;
	
	private String entityIdNum ;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEscalationIds() {
		return escalationIds;
	}

	public void setEscalationIds(String escalationIds) {
		this.escalationIds = escalationIds;
	}

	public int getNoDaysNoResponse() {
		return noDaysNoResponse;
	}

	public void setNoDaysNoResponse(int noDaysNoResponse) {
		this.noDaysNoResponse = noDaysNoResponse;
	}

	public int getReminderPeriod1() {
		return reminderPeriod1;
	}

	public void setReminderPeriod1(int reminderPeriod1) {
		this.reminderPeriod1 = reminderPeriod1;
	}

	public String getReminderIds1() {
		return reminderIds1;
	}

	public void setReminderIds1(String reminderIds1) {
		this.reminderIds1 = reminderIds1;
	}

	public int getReminderPeriod2() {
		return reminderPeriod2;
	}

	public void setReminderPeriod2(int reminderPeriod2) {
		this.reminderPeriod2 = reminderPeriod2;
	}

	public String getReminderIds2() {
		return reminderIds2;
	}

	public void setReminderIds2(String reminderIds2) {
		this.reminderIds2 = reminderIds2;
	}

	public int getReminderPeriod3() {
		return reminderPeriod3;
	}

	public void setReminderPeriod3(int reminderPeriod3) {
		this.reminderPeriod3 = reminderPeriod3;
	}

	public String getReminderIds3() {
		return reminderIds3;
	}

	public void setReminderIds3(String reminderIds3) {
		this.reminderIds3 = reminderIds3;
	}

	
	public String getTemplateEscalation() {
		return templateEscalation;
	}

	public void setTemplateEscalation(String templateEscalation) {
		this.templateEscalation = templateEscalation;
	}

	public String getTemplateReminder() {
		return templateReminder;
	}

	public void setTemplateReminder(String templateReminder) {
		this.templateReminder = templateReminder;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getEntityIdStr() {
		return entityIdStr;
	}

	public void setEntityIdStr(String entityIdStr) {
		this.entityIdStr = entityIdStr;
	}

	public String getEntityIdNum() {
		return entityIdNum;
	}

	public void setEntityIdNum(String entityIdNum) {
		this.entityIdNum = entityIdNum;
	}
	
	
	
}
