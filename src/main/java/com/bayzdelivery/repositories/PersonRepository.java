package com.bayzdelivery.repositories;

import com.bayzdelivery.model.PersonType;
import com.bayzdelivery.model.DeliveryWithCommission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.bayzdelivery.model.Person;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long>, PagingAndSortingRepository<Person, Long> {

  Optional<Person> findByIdAndType(Long id, PersonType type);

  @Query(value = "select p.id, p.name, sum(d.comission) as comission from person p, delivery d \n" +
    "where p.id = d.delivery_man_id " +
    "and p.type = 'DELIVERY'" +
    "and d.start_time between ?1 and ?2" +
    " group by p.id order by sum(d.comission) desc limit 3", nativeQuery = true)
  List<DeliveryWithCommission> findTopThreeEarningDeliveryMen(Instant start, Instant end);
}
