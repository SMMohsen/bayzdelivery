package com.bayzdelivery.dto;

import java.util.List;

public class TopDeliveryMenResponse {

  private List<PersonDTO> delivery;

  private Double avgCommission;

  public TopDeliveryMenResponse(List<PersonDTO> delivery, Double avgCommission) {
    this.delivery = delivery;
    this.avgCommission = avgCommission;
  }

  public List<PersonDTO> getDelivery() {
    return delivery;
  }

  public void setDelivery(List<PersonDTO> delivery) {
    this.delivery = delivery;
  }

  public Double getAvgCommission() {
    return avgCommission;
  }

  public void setAvgCommission(Double avgCommission) {
    this.avgCommission = avgCommission;
  }
}
