package com.bayzdelivery.controller;

import java.util.List;

import com.bayzdelivery.dto.PersonDTO;
import com.bayzdelivery.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bayzdelivery.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

  PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public PersonDTO register(@RequestBody @Valid PersonDTO personDTO) {
    return personService.save(personDTO);
  }

  @GetMapping
  public List<PersonDTO> getAllPersons(@RequestParam(defaultValue = "0", required = false) Integer page, @RequestParam(defaultValue = "10", required = false) Integer offset) {
    return personService.getAll(page, offset);
  }

  @GetMapping("/{person-id}")
  public PersonDTO getPersonById(@PathVariable(name="person-id") Long personId) {
    PersonDTO person = personService.findById(personId);
    if (person != null) {
      return person;
    }
    return null;
  }


}
