package com.h2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMP")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eId;
	private String name;
	private String address;
	
	public int getuId() {
		return eId;
	}
	public void setuId(int uId) {
		this.eId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
