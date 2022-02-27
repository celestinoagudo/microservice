package com.microservice.fraud.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FraudCheckHistory {

  private LocalDateTime createdAt;
  private Long customerId;
  @Id
  @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
  private Long id;

  private Boolean isFraudster;

  public FraudCheckHistory() {}

  public FraudCheckHistory(Long customerId, Boolean isFraudster, LocalDateTime createdAt) {
    this.customerId = customerId;
    this.isFraudster = isFraudster;
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    FraudCheckHistory other = (FraudCheckHistory) obj;
    return Objects.equals(createdAt, other.createdAt)
        && Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
        && Objects.equals(isFraudster, other.isFraudster);
  }

  /**
   * @return the createdAt
   */
  public synchronized LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * @return the customerId
   */
  public synchronized Long getCustomerId() {
    return customerId;
  }

  /**
   * @return the id
   */
  public synchronized Long getId() {
    return id;
  }

  /**
   * @return the isFraudster
   */
  public synchronized Boolean getIsFraudster() {
    return isFraudster;
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, customerId, id, isFraudster);
  }

  /**
   * @param createdAt the createdAt to set
   */
  public synchronized void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @param customerId the customerId to set
   */
  public synchronized void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  /**
   * @param id the id to set
   */
  public synchronized void setId(Long id) {
    this.id = id;
  }

  /**
   * @param isFraudster the isFraudster to set
   */
  public synchronized void setIsFraudster(Boolean isFraudster) {
    this.isFraudster = isFraudster;
  }

  @Override
  public String toString() {
    return "FraudCheckHistory [id=" + id + ", customerId=" + customerId + ", isFraudster="
        + isFraudster + ", createdAt=" + createdAt + "]";
  }

}
