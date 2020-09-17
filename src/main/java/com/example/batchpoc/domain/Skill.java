package com.example.batchpoc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="catalog_skill")
public class Skill {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long skillId;
	
	@Column(name="skill2empleo")
	private Long skill2empleo;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="version")
	private String version;

	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    },fetch=FetchType.LAZY)
	    @JoinTable(name = "skill_provider",
	        joinColumns = @JoinColumn(name = "skill_Id"),
	        inverseJoinColumns = @JoinColumn(name = "provider_Id")
	    )
	private Set<Provider> providers = new HashSet<Provider>();

	public void addProvider(Provider provider) {
		providers.add(provider);
		provider.getSkills().add(this);
	}
	
	public void removeIntegrante (Provider provider) {
		this.providers.remove(provider);
		provider.getSkills().remove(this);
	}
	
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long id) {
		this.skillId = id;
	}

	public Long getSkill2empleo() {
		return skill2empleo;
	}

	public void setSkill2empleo(Long skill2empleo) {
		this.skill2empleo = skill2empleo;
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

	public Set<Provider> getProviders() {
		return providers;
	}

	public void setProviders(Set<Provider> providers) {
		this.providers = providers;
	}
}
