package com.springtest.customerdetails.controllerlayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.customerdetails.CustomerEntity;
import com.springtest.customerdetails.servicelayer.CustomerService;

@RestController
public class CustomerCuntroller {
	
	@Autowired
	CustomerService customerService;
	
	//@RequestMapping(value = "/hello",method =  RequestMethod.GET)
	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hi this is my first springboot";
	}
	
	@RequestMapping(value = "/getcustomers",method =  RequestMethod.GET)
	public List<CustomerEntity> getCustomerDetails() {
		List<CustomerEntity> listCustomer = new ArrayList<CustomerEntity>();
		listCustomer.add(new CustomerEntity(Long.valueOf(14566),"Suresh","Selvaraj","12,west street,Bangalore",Long.valueOf(560093)));
		listCustomer.add(new CustomerEntity(Long.valueOf(19564),"Kannan","panday","#71, MR colony, chennai",Long.valueOf(509702)));
		listCustomer.add(new CustomerEntity(Long.valueOf(15433),"vinay","Rajesh","7/34, vel street, coimbatore",Long.valueOf(600028)));
		return listCustomer;
	}
	
	@RequestMapping(value = "/getcustomersfromservicelayer",method =  RequestMethod.GET)
	public List<CustomerEntity> getCustomerDetailsFromServiceLayer() {
		return customerService.getCustomerDetails();
	}
	
	@RequestMapping(value = "/getcustomersfromdatalayer",method =  RequestMethod.GET)
	public List<CustomerEntity> getCustomerDetailsFromDataLayer() {
		return customerService.getCustomerDetailsFromDataLayer();
	}
	
	/* pathvariable is http://localhost/book/19734
	 * pathparam is  http://localhost/book?id=19734*/
	@RequestMapping(value = "/getcustomersfromdatalayer/{customerid}",method =  RequestMethod.GET)
	public CustomerEntity getCustomer(@PathVariable("customerid") Long id) {
		return customerService.getCustomerById(id);
	}

}
