package com.bayzdelivery.service;

import java.time.Instant;
import java.util.List;

import com.bayzdelivery.dto.PersonDTO;
import com.bayzdelivery.dto.TopDeliveryMenResponse;
import com.bayzdelivery.model.Person;

public interface PersonService {
  public List<PersonDTO> getAll(Integer page, Integer offset);

  public PersonDTO save(PersonDTO p);

  public PersonDTO findById(Long personId);

  public TopDeliveryMenResponse findTopThreeEarningsDeliveryMen(Instant start, Instant end);

}
