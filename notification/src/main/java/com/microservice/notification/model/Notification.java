package com.microservice.notification.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Notification {

  @Id
  @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
  private Long id;
  private String message;
  private String recepientCustomerEmail;
  private String sender;
  private LocalDateTime sentAt;

  private Long toCustomerId;

  public Notification() {}

  public Notification(String message, String recepientCustomerEmail, String sender,
      LocalDateTime sentAt, Long toCustomerId) {
    this.message = message;
    this.recepientCustomerEmail = recepientCustomerEmail;
    this.sender = sender;
    this.sentAt = sentAt;
    this.toCustomerId = toCustomerId;
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
    Notification other = (Notification) obj;
    return Objects.equals(id, other.id) && Objects.equals(message, other.message)
        && Objects.equals(recepientCustomerEmail, other.recepientCustomerEmail)
        && Objects.equals(sender, other.sender) && Objects.equals(sentAt, other.sentAt)
        && Objects.equals(toCustomerId, other.toCustomerId);
  }

  /**
   * @return the id
   */
  public synchronized Long getId() {
    return id;
  }

  /**
   * @return the message
   */
  public synchronized String getMessage() {
    return message;
  }

  /**
   * @return the recepientCustomerEmail
   */
  public synchronized String getRecepientCustomerEmail() {
    return recepientCustomerEmail;
  }

  /**
   * @return the sender
   */
  public synchronized String getSender() {
    return sender;
  }

  /**
   * @return the sentAt
   */
  public synchronized LocalDateTime getSentAt() {
    return sentAt;
  }

  /**
   * @return the toCustomerId
   */
  public synchronized Long getToCustomerId() {
    return toCustomerId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message, recepientCustomerEmail, sender, sentAt, toCustomerId);
  }

  /**
   * @param id the id to set
   */
  public synchronized void setId(Long id) {
    this.id = id;
  }

  /**
   * @param message the message to set
   */
  public synchronized void setMessage(String message) {
    this.message = message;
  }

  /**
   * @param recepientCustomerEmail the recepientCustomerEmail to set
   */
  public synchronized void setRecepientCustomerEmail(String recepientCustomerEmail) {
    this.recepientCustomerEmail = recepientCustomerEmail;
  }

  /**
   * @param sender the sender to set
   */
  public synchronized void setSender(String sender) {
    this.sender = sender;
  }

  /**
   * @param sentAt the sentAt to set
   */
  public synchronized void setSentAt(LocalDateTime sentAt) {
    this.sentAt = sentAt;
  }

  /**
   * @param toCustomerId the toCustomerId to set
   */
  public synchronized void setToCustomerId(Long toCustomerId) {
    this.toCustomerId = toCustomerId;
  }

  @Override
  public String toString() {
    return "Notification [id=" + id + ", message=" + message + ", recepientCustomerEmail="
        + recepientCustomerEmail + ", sender=" + sender + ", sentAt=" + sentAt + ", toCustomerId="
        + toCustomerId + "]";
  }

}
