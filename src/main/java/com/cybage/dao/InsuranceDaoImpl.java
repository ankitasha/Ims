package com.cybage.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.model.Customer;
import com.cybage.model.Insurance;

@Repository
public class InsuranceDaoImpl implements InsuranceDao {

	
	@Autowired
	SessionFactory sf;
	
	
	@Override
	public List<Insurance> getInsurance() {
		System.out.println("Autowired worked");
	     @SuppressWarnings("unchecked")
		List<Insurance> allInsurance= sf.getCurrentSession().createQuery("from Insurance")
	    		                       .list();
			return allInsurance;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insurance> searchInsurance(String code) {
		return sf.getCurrentSession().createQuery("from Insurance where insurancecode="+code).list();

	}

	@Override
	public void addInsurance(Insurance insurance) {
      sf.getCurrentSession().save(insurance);		
	}

	@Override
	public void removeInsurance(int id) 
	{
	 Insurance insurance= new Insurance();
	 insurance.setInsuranceid(id);
	 sf.getCurrentSession().delete(insurance);
	}

	@Override
	public void updateInsurance(Insurance insurance, int id)
	{ insurance.setInsuranceid(id);
	  sf.getCurrentSession().update(insurance);
	}

	@Override
	public List<Insurance> searchInsurance(int id) {
		return sf.getCurrentSession().createQuery("from Insurance where insuranceid="+id).list();
	}

	@Override
	public List<Customer> searchCustomer(String code) {
		System.out.println("in searchCustomer...InsuranceDao"+code);
		String query="select customer.customerId from Insurance where insurancecode="+code;
		return sf.getCurrentSession().createQuery("from Customer where customerId="+query).list();
	}

}
