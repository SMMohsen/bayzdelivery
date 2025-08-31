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

  @Column(name = "comission")
  Long comission;

  @NotNull
  PersonDTO deliveryId;

  @NotNull
  PersonDTO customerId;

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

  public PersonDTO getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(PersonDTO deliveryId) {
    this.deliveryId = deliveryId;
  }

  public PersonDTO getCustomerId() {
    return customerId;
  }

  public void setCustomerId(PersonDTO customerId) {
    this.customerId = customerId;
  }
}
