package com.bayzdelivery.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class DeliveryDTO {

  Long id;

  @NotNull
  Instant startTime;

  @NotNull
  Instant endTime;

  Long distance;

  Long price;

  Long comission;

  @NotNull
  PersonDTO deliveryMan;

  @NotNull
  PersonDTO customer;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public void setStartTime(Instant startTime) {
    this.startTime = startTime;
  }

  public Instant getEndTime() {
    return endTime;
  }

  public void setEndTime(Instant endTime) {
    this.endTime = endTime;
  }

  public Long getDistance() {
    return distance;
  }

  public void setDistance(Long distance) {
    this.distance = distance;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getComission() {
    return comission;
  }

  public void setComission(Long comission) {
    this.comission = comission;
  }

  public PersonDTO getDeliveryMan() {
    return deliveryMan;
  }

  public void setDeliveryMan(PersonDTO deliveryMan) {
    this.deliveryMan = deliveryMan;
  }

  public PersonDTO getCustomer() {
    return customer;
  }

  public void setCustomer(PersonDTO customer) {
    this.customer = customer;
  }
}
