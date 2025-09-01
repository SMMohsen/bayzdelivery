package com.bayzdelivery.service;

import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;

import java.util.List;

public interface DeliveryService {

  public DeliveryDTO save(CreateDeliveryDTO delivery);

  public DeliveryDTO findById(Long deliveryId);

  public List<Long> findLateDeliveries(Long minutesAllowedToDeliver);
}
