package com.cybage.services;

import java.util.Date;
import java.util.List;

import com.cybage.model.Customer;
import com.cybage.model.Insurance;

public interface CustomerService
{
	List<Customer> getCustomer();
	List searchCustomer(String name);
	List searchCustomer(int id);
	void addCustomer(Customer customer);//String name,String address,Integer phone,Date dob
	void removeCustomer(int del_id);
	void updateCustomer(Customer customer,int id);
	public List<Insurance> searchInsurance(int id) ;

}
