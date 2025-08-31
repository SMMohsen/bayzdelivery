package com.bayzdelivery.service;

import java.util.List;

import com.bayzdelivery.dto.PersonDTO;
import com.bayzdelivery.model.Person;

public interface PersonService {
  public List<PersonDTO> getAll();

  public PersonDTO save(PersonDTO p);

  public PersonDTO findById(Long personId);

}
