package com.microservice.fraud.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.fraud.model.FraudCheckHistory;
import com.microservice.fraud.repository.FraudCheckHistoryRepository;

@Service
public class FraudCheckHistoryService {

  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  public FraudCheckHistoryService(
      @Autowired FraudCheckHistoryRepository fraudCheckHistoryRepository) {
    this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
  }

  public boolean isFraudulentCustomer(Long customerId) {

    boolean isFraudster = false;

    FraudCheckHistory fraudCheckHistory =
        new FraudCheckHistory(customerId, isFraudster, LocalDateTime.now());
    fraudCheckHistoryRepository.save(fraudCheckHistory);

    return isFraudster;
  }

}
