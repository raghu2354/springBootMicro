package com.springmicro.services.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springmicro.services.web.model.CustomerDto;
import com.springmicro.services.web.service.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> get(@PathVariable("customerId") UUID customerId) 
	{
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){

		CustomerDto saveDto=customerService.saveCustomer(customerDto);

		HttpHeaders headers= new HttpHeaders();
		headers.add("location", "/api/v1/customer/"+saveDto.getId().toString());
		return new ResponseEntity(headers,HttpStatus.CREATED);

	}
	@PutMapping("/{customerId}")
	public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto){	

		customerService.updateCustomer(customerId, customerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable("customerId") UUID customerId){
		
		customerService.deleteCustomer(customerId);

	}

}
