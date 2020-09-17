package com.amdocs.jceapi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="catalog_empleo")
public class Empleo {

	@Id
	@GeneratedValue
	@Column(name="empleoid")
	private Long empleoId;
	
	@Column(name="empleo2category")
	private Long empleo2category;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="version")
	private String version;
	
	@Transient
	private List<Skill> skillList;
	

	public Long getEmpleoId() {
		return empleoId;
	}

	public void setEmpleoId(Long empleoId) {
		this.empleoId = empleoId;
	}

	public Long getcategoryid() {
		return empleo2category;
	}

	public void setcategoryid(Long categoryid) {
		this.empleo2category = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}
}
