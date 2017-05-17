package com.cybage.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.cybage.model.Customer;
import com.cybage.model.Insurance;

public interface CustomerDao 
{
List<Customer> getCustomer();
List searchCustomer(String name);
List searchCustomer(int id);
void addCustomer(Customer customer);
void removeCustomer(int del_id);
void updateCustomer(Customer customer,int id);
List<Insurance> searchInsurance(int id);

}
