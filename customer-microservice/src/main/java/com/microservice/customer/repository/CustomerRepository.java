package com.microservice.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
