package com.bayzdelivery.mapper;

import com.bayzdelivery.dto.PersonDTO;
import com.bayzdelivery.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

  PersonDTO toDTO(Person person);
  Person toEntity(PersonDTO personDTO);
}
