package com.bayzdelivery.service;

import java.util.List;
import java.util.Optional;


import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.exceptions.ResourceNotFoundException;
import com.bayzdelivery.mapper.DelievryMapper;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.model.PersonType;
import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {


  private DeliveryRepository deliveryRepository;

  private PersonRepository personRepository;

  private DelievryMapper delievryMapper;

  public DeliveryServiceImpl(DeliveryRepository deliveryRepository, PersonRepository personRepository, DelievryMapper delievryMapper) {
    this.deliveryRepository = deliveryRepository;
    this.personRepository = personRepository;
    this.delievryMapper = delievryMapper;
  }

  public DeliveryDTO save(CreateDeliveryDTO deliveryDTO) {

    Person customer = personRepository.findByIdAndType(deliveryDTO.getCustomerId(), PersonType.CUSTOMER).orElseThrow(() -> new ResourceNotFoundException());
    Person deliveryMan = personRepository.findByIdAndType(deliveryDTO.getDeliveryId(), PersonType.DELIVERY).orElseThrow(() -> new ResourceNotFoundException());
    Delivery delivery = delievryMapper.toEntity(deliveryDTO);

    delivery.setDeliveryMan(deliveryMan);
    delivery.setCustomer(customer);
    delivery.calculateCommission();

    return delievryMapper.toDTO(deliveryRepository.save(delivery));
  }

  public DeliveryDTO findById(Long deliveryId) {
    Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);

    return delievryMapper.toDTO(optionalDelivery.orElseThrow(() -> new ResourceNotFoundException()));
  }

  public List<Long> findLateDeliveries(Long minutesAllowedToDeliver) {

    return deliveryRepository.findDeliveriesExceededMinutesAllowed(minutesAllowedToDeliver);

  }
}
