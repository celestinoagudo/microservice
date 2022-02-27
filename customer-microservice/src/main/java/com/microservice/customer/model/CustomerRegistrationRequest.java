package com.microservice.customer.model;

import java.util.Objects;

public class CustomerRegistrationRequest {

  private String email;
  private String firstName;
  private String lastName;

  public CustomerRegistrationRequest() {}

  public CustomerRegistrationRequest(String email, String firstName, String lastName) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
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
    CustomerRegistrationRequest other = (CustomerRegistrationRequest) obj;
    return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
        && Objects.equals(lastName, other.lastName);
  }

  /**
   * @return the email
   */
  public synchronized String getEmail() {
    return email;
  }

  /**
   * @return the firstName
   */
  public synchronized String getFirstName() {
    return firstName;
  }

  /**
   * @return the lastName
   */
  public synchronized String getLastName() {
    return lastName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, firstName, lastName);
  }

  /**
   * @param email the email to set
   */
  public synchronized void setEmail(String email) {
    this.email = email;
  }

  /**
   * @param firstName the firstName to set
   */
  public synchronized void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param lastName the lastName to set
   */
  public synchronized void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "CustomerRegistrationRequest [email=" + email + ", firstName=" + firstName
        + ", lastName=" + lastName + "]";
  }

}
