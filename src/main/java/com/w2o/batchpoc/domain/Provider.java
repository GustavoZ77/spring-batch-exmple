package com.amdocs.jceapi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="provider")
public class Provider {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long providerId;
	
	@Column(name="firstname",columnDefinition = "char(200)")
	private String firstName;
	
	@Column(name="lastname",columnDefinition = "char(200)")
	private String lastName;
	
	@Column(name="age",columnDefinition = "int")
	private Integer age;
	
	@Column(name="gender", columnDefinition = "char(1)")
	private String gender;

	@ManyToMany(mappedBy = "providers", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Skill> skills = new HashSet<Skill>();
	
	public Provider() {
		super();
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long id) {
		this.providerId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
}
