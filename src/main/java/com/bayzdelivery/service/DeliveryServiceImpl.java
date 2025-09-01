package com.bayzdelivery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.dto.TopDeliveryMenResponse;
import com.bayzdelivery.exceptions.ResourceNotFoundException;
import com.bayzdelivery.mapper.DelievryMapper;
import com.bayzdelivery.mapper.PersonMapper;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.model.PersonType;
import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.repositories.PersonRepository;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {


  private DeliveryRepository deliveryRepository;

  private PersonRepository personRepository;

  private DelievryMapper delievryMapper;

  private PersonMapper personMapper;

  public DeliveryServiceImpl(DeliveryRepository deliveryRepository, PersonRepository personRepository, DelievryMapper delievryMapper, PersonMapper personMapper) {
    this.deliveryRepository = deliveryRepository;
    this.personRepository = personRepository;
    this.delievryMapper = delievryMapper;
    this.personMapper = personMapper;
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

  @Override
  public TopDeliveryMenResponse getTop3DeliveryMen() {

    List<Delivery> topDeliveries = deliveryRepository.findByOrderByComissionDesc(Limit.of(3));

    return new TopDeliveryMenResponse(topDeliveries.stream().map(d -> personMapper.toDTO(d.getDeliveryMan())).collect(Collectors.toList()), topDeliveries.stream().mapToDouble(d -> d.getComission()).average().orElseGet(() -> 0.0));
  }
}
