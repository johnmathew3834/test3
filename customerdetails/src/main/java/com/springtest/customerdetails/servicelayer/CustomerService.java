package com.springtest.customerdetails.servicelayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.customerdetails.CustomerEntity;
import com.springtest.customerdetails.dataleyer.CustomerDataLayer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDataLayer customerDataLayer;
	
	public List<CustomerEntity> getCustomerDetails(){
		List<CustomerEntity> listCustomer = new ArrayList<CustomerEntity>();
		listCustomer.add(new CustomerEntity(Long.valueOf(14566),"Suresh_servicelayer","Selvaraj","12,west street,Bangalore",Long.valueOf(560093)));
		listCustomer.add(new CustomerEntity(Long.valueOf(19564),"Kannan_servicelayer","panday","#71, MR colony, chennai",Long.valueOf(509702)));
		listCustomer.add(new CustomerEntity(Long.valueOf(15433),"vinay_servicelayer","Rajesh","7/34, vel street, coimbatore",Long.valueOf(600028)));
		return listCustomer;
	}
	
	public List<CustomerEntity> getCustomerDetailsFromDataLayer(){
		List<CustomerEntity> listCustomer = new ArrayList<CustomerEntity>();
		customerDataLayer.findAll().forEach(customer -> listCustomer.add(customer));
		return listCustomer;
	}
	
	public CustomerEntity getCustomerById(Long id) {
		return customerDataLayer.findById(id).orElse(null);
	}
}
