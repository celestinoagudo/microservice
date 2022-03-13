package com.microservice.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.amqp.RabbitMqMessageProducer;
import com.microservice.clients.fraud.FraudClient;
import com.microservice.clients.model.FraudCheckResponse;
import com.microservice.clients.model.NotificationRequest;
import com.microservice.customer.model.Customer;
import com.microservice.customer.model.CustomerRegistrationRequest;
import com.microservice.customer.repository.CustomerRepository;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final FraudClient fraudClient;
  private final RabbitMqMessageProducer messageProducer;


  @Autowired
  public CustomerService(CustomerRepository customerRepository, FraudClient fraudClient,
      RabbitMqMessageProducer messageProducer) {

    this.customerRepository = customerRepository;
    this.fraudClient = fraudClient;
    this.messageProducer = messageProducer;

  }

  public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

    Customer customer = new Customer(customerRegistrationRequest.getEmail(),
        customerRegistrationRequest.getFirstName(), customerRegistrationRequest.getLastName());

    customerRepository.saveAndFlush(customer);

    FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

    if (response.getIsFraudster()) {
      throw new RuntimeException("Fraudster");
    }

    NotificationRequest request = new NotificationRequest("Registered successfully",
        customer.getEmail(), "Admin", customer.getId());

    messageProducer.publish(request, "internal.exchange", "interntal.notification.routing-key");
  }

}
