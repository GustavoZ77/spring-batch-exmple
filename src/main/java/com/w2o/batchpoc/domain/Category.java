package com.w2o.batchpoc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="catalog_category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name="categoryid")
	private Long categoryId;
	
	@Column(name="name",columnDefinition = "character varying(200)")	
	private String name;
	
	@Column(name="version",columnDefinition = "character varying(50)")
	private String version;
	
	@Column(name="description",columnDefinition = "character varying(200)")
	private String description;
	
	@Transient
	private List<Empleo> empleoList;
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Empleo> getEmpleoList() {
		return empleoList;
	}

	public void setEmpleoList(List<Empleo> empleoList) {
		this.empleoList = empleoList;
	}

	@Override
	public String toString() {
		return String.format("Catagories [id=%s, name=%s, version=%s , description = %S]", 
				categoryId.toString(), name, version,toString(), description.toString());
	}
}
