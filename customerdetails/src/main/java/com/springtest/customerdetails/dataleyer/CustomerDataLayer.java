package com.springtest.customerdetails.dataleyer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtest.customerdetails.CustomerEntity;

public interface CustomerDataLayer extends JpaRepository<CustomerEntity, Long> {

}
