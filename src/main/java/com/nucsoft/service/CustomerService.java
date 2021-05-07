package com.nucsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nucsoft.model.CustomerModel;
import com.nucsoft.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Mono<CustomerModel> add(CustomerModel payload)
	{
		return customerRepository.save(payload);
	}
	
	public Flux<CustomerModel> getCustomerDetails()
	{
		return customerRepository.findAll();
	}
	
	
	public Mono<CustomerModel> getCustomerById(String id)
	{
		return customerRepository.findById(id);
	}
	
	public Mono<Void> DeleteById(String id)
	{
		return customerRepository.deleteById(id);
	}
	
	public Mono<CustomerModel> UpdateCustomerByID(String id,CustomerModel payload)
	{
		return customerRepository.findById(id)
				.flatMap(data->{
					payload.setId(id);
					return customerRepository.save(payload);
				});
	}
}
