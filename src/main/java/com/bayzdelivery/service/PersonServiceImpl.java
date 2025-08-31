package com.bayzdelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bayzdelivery.dto.PersonDTO;
import com.bayzdelivery.mapper.PersonMapper;
import com.bayzdelivery.repositories.PersonRepository;
import com.bayzdelivery.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    private PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList.stream()
          .map(p -> personMapper.toDTO(p))
          .collect(Collectors.toList());
    }

    public PersonDTO save(PersonDTO p) {
        return personMapper.toDTO(personRepository.save(personMapper.toEntity(p)));
    }

    @Override
    public PersonDTO findById(Long personId) {
        Optional<Person> dbPerson = personRepository.findById(personId);
        return dbPerson.map(p -> personMapper.toDTO(p)).orElse(null);
    }
}
