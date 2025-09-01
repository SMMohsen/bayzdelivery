package com.bayzdelivery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.bayzdelivery.model.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long>, PagingAndSortingRepository<Person, Long> {

  Optional<Person> findByIdAndType(Long id, String type);
}
