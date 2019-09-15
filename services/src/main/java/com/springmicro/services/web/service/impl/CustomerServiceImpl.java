package com.springmicro.services.web.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springmicro.services.web.model.CustomerDto;
import com.springmicro.services.web.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		
		return CustomerDto.builder().id(UUID.randomUUID())
				.customerName("Paul Beer")
				.build();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.customerName(customerDto.getCustomerName())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		// TODO Auto-generated method stub
		
	}

}
