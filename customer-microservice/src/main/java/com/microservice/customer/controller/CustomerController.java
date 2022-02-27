package com.microservice.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.customer.model.CustomerRegistrationRequest;
import com.microservice.customer.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

  private CustomerService customerService;

  public CustomerController(@Autowired CustomerService customerService) {

    this.customerService = customerService;
  }

  @PostMapping
  public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {

    LOGGER.info("new customer registration: {}", customerRequest);

    customerService.registerCustomer(customerRequest);
  }

}
