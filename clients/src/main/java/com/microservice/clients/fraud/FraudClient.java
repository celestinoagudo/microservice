package com.microservice.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.microservice.clients.model.FraudCheckResponse;

@FeignClient(name = "fraud", path = "api/v1/fraud-check", url = "${clients.fraud.url}")
public interface FraudClient {

  @GetMapping(path = "{customerId}")
  FraudCheckResponse isFraudster(@PathVariable("customerId") Long id);
}
