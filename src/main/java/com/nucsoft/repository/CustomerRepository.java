package com.nucsoft.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nucsoft.model.CustomerModel;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerModel, Long> {

	Mono<CustomerModel> findById(String id);

	Mono<Void> deleteById(String id);

}
