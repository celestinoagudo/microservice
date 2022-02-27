package com.microservice.clients.model;

public class FraudCheckResponse {

  private Boolean isFraudster;

  public FraudCheckResponse() {}

  public FraudCheckResponse(Boolean isFraudster) {

    this.isFraudster = isFraudster;

  }

  /**
   * @return the isFraudster
   */
  public synchronized Boolean getIsFraudster() {
    return isFraudster;
  }

  /**
   * @param isFraudster the isFraudster to set
   */
  public synchronized void setIsFraudster(Boolean isFraudster) {
    this.isFraudster = isFraudster;
  }

}
