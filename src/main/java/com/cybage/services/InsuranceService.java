package com.cybage.services;

import java.util.List;

import com.cybage.model.Customer;
import com.cybage.model.Insurance;

public interface InsuranceService {
	List<Insurance> getInsurance();
	 List<Insurance> searchInsurance(String code);
	 List<Insurance> searchInsurance(int id);
	 void addInsurance(Insurance insurance);
	 void removeInsurance(int id);
	 void updateInsurance(Insurance insurance,int id);
	 public List<Customer> searchCustomer(String code);
}
