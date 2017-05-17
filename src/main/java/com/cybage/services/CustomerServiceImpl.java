package com.cybage.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.CustomerDao;
import com.cybage.dao.CustomerDaoImpl;
import com.cybage.model.Customer;
import com.cybage.model.Insurance;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
   @Autowired
   CustomerDao customerdao;
	
	@Override
	public List<Customer> getCustomer() {
		System.out.println(customerdao instanceof CustomerDaoImpl);
		return customerdao.getCustomer();
	}

	@Override
	public List searchCustomer(String name) {
		return customerdao.searchCustomer(name);
	}

	@Override
	public void addCustomer(Customer customer) {
	  System.out.println("in add cutomer... service");
	  customerdao.addCustomer(customer);
		
	}

	@Override
	public void removeCustomer(int del_id) {
         customerdao.removeCustomer(del_id);		
	}

	@Override
	public void updateCustomer(Customer customer, int id) {
        customerdao.updateCustomer(customer, id);		
	}

	@Override
	public List searchCustomer(int id) {
		return customerdao.searchCustomer(id);
	}

	@Override
	public List<Insurance> searchInsurance(int id) {
		return customerdao.searchInsurance(id);
	}
	

}
