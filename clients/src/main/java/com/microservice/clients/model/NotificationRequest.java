package com.microservice.clients.model;

public class NotificationRequest {

  private String message;
  private String recepientCustomerEmail;
  private String sender;
  private Long toCustomerId;

  public NotificationRequest() {}

  public NotificationRequest(String message, String recepientCustomerEmail, String sender,
      Long toCustomerId) {
    this.message = message;
    this.recepientCustomerEmail = recepientCustomerEmail;
    this.sender = sender;
    this.toCustomerId = toCustomerId;
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
   * @return the toCustomerId
   */
  public synchronized Long getToCustomerId() {
    return toCustomerId;
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
   * @param toCustomerId the toCustomerId to set
   */
  public synchronized void setToCustomerId(Long toCustomerId) {
    this.toCustomerId = toCustomerId;
  }

}
