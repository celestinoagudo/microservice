package com.microservice.customer.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

  private String email;

  private String firstName;

  @Id
  @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
  private Long id;

  private String lastName;

  public Customer() {}

  public Customer(String email, String firstName, String lastName) {
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
    Customer other = (Customer) obj;
    return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
        && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
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
   * @return the id
   */
  public synchronized Long getId() {
    return id;
  }

  /**
   * @return the lastName
   */
  public synchronized String getLastName() {
    return lastName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, firstName, id, lastName);
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
   * @param id the id to set
   */
  public synchronized void setId(Long id) {
    this.id = id;
  }

  /**
   * @param lastName the lastName to set
   */
  public synchronized void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Customer [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName="
        + lastName + "]";
  }
}
