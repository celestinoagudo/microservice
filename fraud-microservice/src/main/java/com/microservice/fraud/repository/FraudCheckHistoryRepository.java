package com.microservice.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.fraud.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Long> {

}
