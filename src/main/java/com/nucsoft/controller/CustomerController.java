package com.nucsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nucsoft.model.CustomerModel;
import com.nucsoft.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@CrossOrigin(origins = "")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/test")
	public String test()
	{
		return "Successful";
	}
	
	
	@PostMapping("/addCustomerDetails")
	public Mono<CustomerModel> addpayload(@RequestBody CustomerModel payload)
	{
		return customerService.add(payload);
	}
	
	@GetMapping("/getCustomerDetails")
	public Flux<CustomerModel> GetCustomerDetails()
	{
		return customerService.getCustomerDetails();
	}
	
	@GetMapping("/getCustomerbyId/{id}")
	public Mono<CustomerModel> GetCustomerById(@PathVariable ("id") String id)
	{
		return customerService.getCustomerById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Mono<Void> DeleteCustomerById(@PathVariable ("id") String id)
	{
		return customerService.DeleteById(id);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Mono<CustomerModel> UpdateCustomerById(@PathVariable ("id") String id,@RequestBody CustomerModel payload)
	{
		return customerService.UpdateCustomerByID(id, payload);
	}
	
}
