package com.cybage.dao;

import java.util.Comparator;

import com.cybage.model.Insurance;

public class sortInsuranceByCustomerId implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Insurance i1=(Insurance) o1;
		Insurance i2=(Insurance) o2;
        return compare(i1.getCustomer().getCustomerId(), i2.getCustomer().getCustomerId());		
	}

}
