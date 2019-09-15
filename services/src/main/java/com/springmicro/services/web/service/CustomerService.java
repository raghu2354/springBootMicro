package com.springmicro.services.web.service;

import java.util.UUID;

import com.springmicro.services.web.model.BeerDto;
import com.springmicro.services.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveCustomer(CustomerDto customerDto);
	void updateCustomer(UUID customerId, CustomerDto customerDto);

	void deleteCustomer(UUID customerId);

}
