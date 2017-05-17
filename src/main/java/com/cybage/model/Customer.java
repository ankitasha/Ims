package com.cybage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customer")
public class Customer implements Serializable
{
private static final long serialVersionUID = -1798070786993154676L;

private int customerId;
private String name;
private String address;
private Integer phone;
private Date dob;
private Set<Insurance> insurance;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="customerid",unique=true)
public int getCustomerId() {
	return customerId;
}

public void setInsurance(Set<Insurance> insurance) {
	this.insurance = insurance;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

@Column(name="customerName")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Column(name="customerAddress")
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Column(name="customerPhone")
public Integer getPhone() {
	return phone;
}
public void setPhone(Integer phone) {
	this.phone = phone;
}

@Column(name="customerDob")
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}

public Customer() {
	super();
}

@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="customer")
public Set<Insurance> getInsurance() {
	return insurance;
}





public Customer(int customerId, String name, Set<Insurance> insurance) {
	super();
	this.customerId = customerId;
	this.name = name;
	this.insurance = insurance;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", phone=" + phone
			+ ", dob=" + dob + "]";
}


}
