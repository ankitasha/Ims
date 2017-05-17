package com.cybage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="insurance")
public class Insurance implements Serializable 
{  
  private static final long serialVersionUID = -6790693372846798580L;
  private int insuranceid;
  private String insurancecode;
  private String type;
 private Date dateofIssuance;
  private Date dateofRenewal;
  private Date dateofExpiry;
  private Customer customer;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="insuranceid",unique=true,nullable=false)
public int getInsuranceid() {
	return insuranceid;
}
public void setInsuranceid(int insuranceid) {
	this.insuranceid = insuranceid;
}
@Column(name="insurancecode")
public String getInsurancecode() {
	return insurancecode;
}
public void setInsurancecode(String insurancecode) {
	this.insurancecode = insurancecode;
}

@Column(name="dateofIssuance")
public Date getDateofIssuance() {
	return dateofIssuance;
}
public void setDateofIssuance(Date dateofIssuance) {
	this.dateofIssuance = dateofIssuance;
}

@Column(name="dateofRenewal")
public Date getDateofRenewal() {
	return dateofRenewal;
}
public void setDateofRenewal(Date dateofRenewal) {
	this.dateofRenewal = dateofRenewal;
}

@Column(name="dateofExpiry")
public Date getDateofExpiry() {
	return dateofExpiry;
}
public void setDateofExpiry(Date dateofExpiry) {
	this.dateofExpiry = dateofExpiry;
}

@Column(name="type")
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}




@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name = "customer")
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Insurance() {
	super();
}


public Insurance(int insuranceid, String insurancecode, Customer customer) {
	super();
	this.insuranceid = insuranceid;
	this.insurancecode = insurancecode;
	this.customer = customer;
}

public Insurance(int insuranceid, String insurancecode, Date dateofIssuance, Date dateofRenewal, Date dateofExpiry,
		String type,Customer customer) {
	super();
	this.insuranceid = insuranceid;
	this.insurancecode = insurancecode;
	this.dateofIssuance = dateofIssuance;
	this.dateofRenewal = dateofRenewal;
	this.dateofExpiry = dateofExpiry;
	this.type=type;
	this.customer = customer;
}
@Override
public String toString() {
	return "Insurance [insuranceid=" + insuranceid + ", insurancecode=" + insurancecode + ", type=" + type
			+ ", dateofIssuance=" + dateofIssuance + ", dateofRenewal=" + dateofRenewal + ", dateofExpiry="
			+ dateofExpiry + ", customer=" + customer + "]";
}

}
 	
	

