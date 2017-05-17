package com.cybage.remotting.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.cybage.dao.CustomerDaoImpl;
import com.cybage.model.Customer;
import com.cybage.model.Insurance;
import com.cybage.services.CustomerService;

@Component
@WebService(serviceName="InsuranceService")
public class insuranceServiceEndPoint extends SpringBeanAutowiringSupport
{
  @Autowired
  CustomerService customerService;
  
  @WebMethod
  public List<Customer> getCustomer() {
		System.out.println("in insuranceServiceEndPoint..");
		return customerService.getCustomer();
	}
  @WebMethod
	public List searchCustomer(String name) {
		System.out.println("in insuranceServiceEndPoint..");
		return customerService.searchCustomer(name);	}
  @WebMethod
	public void addCustomer(Customer customer) {
	  System.out.println("in add cutomer... service");
       customerService.addCustomer(customer);		
	}
  @WebMethod
	public void removeCustomer(int del_id) {
     customerService.removeCustomer(del_id);
	}
  @WebMethod
	public void updateCustomer(Customer customer, int id) {
		customerService.updateCustomer(customer, id);
	}
  @WebMethod
	public List searchCustomer(int id) {
		return customerService.searchCustomer(id);
	}
  @WebMethod
	public List<Insurance> searchInsurance(int id) {
		return customerService.searchInsurance(id);
	}
	

  

}
