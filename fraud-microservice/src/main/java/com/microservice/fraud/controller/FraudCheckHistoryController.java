package com.microservice.fraud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.clients.model.FraudCheckResponse;
import com.microservice.fraud.service.FraudCheckHistoryService;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckHistoryController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FraudCheckHistoryController.class);

  private final FraudCheckHistoryService fraudCheckHistoryService;

  public FraudCheckHistoryController(@Autowired FraudCheckHistoryService fraudCheckHistoryService) {
    this.fraudCheckHistoryService = fraudCheckHistoryService;
  }

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Long id) {

    LOGGER.info("Fraud check history for customer with id: {}", id);

    boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(id);

    return new FraudCheckResponse(isFraudulentCustomer);
  }



}
