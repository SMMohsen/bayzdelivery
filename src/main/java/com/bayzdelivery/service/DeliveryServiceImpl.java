package com.bayzdelivery.service;

import java.util.Optional;

import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.exceptions.ResourceNotFoundException;
import com.bayzdelivery.mapper.DelievryMapper;
import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.model.Delivery;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {


  private DeliveryRepository deliveryRepository;

  private DelievryMapper delievryMapper;

  public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DelievryMapper delievryMapper) {
    this.deliveryRepository = deliveryRepository;
    this.delievryMapper = delievryMapper;
  }

  public DeliveryDTO save(CreateDeliveryDTO deliveryDTO) {

    Delivery delivery = delievryMapper.toEntity(deliveryDTO);
    return delievryMapper.toDTO(deliveryRepository.save(delivery));
  }

  public DeliveryDTO findById(Long deliveryId) {
    Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);

    return delievryMapper.toDTO(optionalDelivery.orElseThrow(() -> new ResourceNotFoundException()));
  }
}
