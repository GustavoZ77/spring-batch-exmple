package com.amdocs.jceapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name="idaddress")
	private Long id;
	
	@Column
	private String addressLine1;
	
	@Column
	private String colony;
	
	@Column
	private String muncipality;
	
	@Column
	private String zipcode;
	
	@Column
	private String state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getMuncipality() {
		return muncipality;
	}
	public void setMuncipality(String muncipality) {
		this.muncipality = muncipality;
	}

	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
