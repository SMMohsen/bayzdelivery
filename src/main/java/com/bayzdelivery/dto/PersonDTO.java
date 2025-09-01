package com.bayzdelivery.dto;

import com.bayzdelivery.model.PersonType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class PersonDTO {

  Long id;

  @NotNull
  String name;

  @NotNull
  @Email
  String email;

  String registrationNumber;

  @NotNull
  PersonType type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public PersonType getType() {
    return type;
  }

  public void setType(PersonType type) {
    this.type = type;
  }
}
