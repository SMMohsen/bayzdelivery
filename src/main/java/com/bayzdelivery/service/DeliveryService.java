package com.bayzdelivery.service;

import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.model.Delivery;

public interface DeliveryService {

  public DeliveryDTO save(CreateDeliveryDTO delivery);

  public DeliveryDTO findById(Long deliveryId);
}
