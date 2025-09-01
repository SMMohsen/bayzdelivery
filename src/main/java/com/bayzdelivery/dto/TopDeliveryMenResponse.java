package com.bayzdelivery.dto;

import com.bayzdelivery.model.DeliveryWithCommission;

import java.util.List;

public class TopDeliveryMenResponse {

  private List<DeliveryWithCommission> delivery;

  private Double avgCommission;

  public TopDeliveryMenResponse(List<DeliveryWithCommission> delivery, Double avgCommission) {
    this.delivery = delivery;
    this.avgCommission = avgCommission;
  }

  public List<DeliveryWithCommission> getDelivery() {
    return delivery;
  }

  public void setDelivery(List<DeliveryWithCommission> delivery) {
    this.delivery = delivery;
  }

  public Double getAvgCommission() {
    return avgCommission;
  }

  public void setAvgCommission(Double avgCommission) {
    this.avgCommission = avgCommission;
  }
}
