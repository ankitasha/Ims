package com.cybage.dao;

import java.util.Comparator;

import com.cybage.model.Insurance;

public class sortInsuranceByDateOfExpiry implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) 
	{  
		Insurance ins1= (Insurance) o1;
		Insurance ins2= (Insurance) o2;
		return ins1.getDateofExpiry().compareTo(ins2.getDateofExpiry());
	}
  
	
}
