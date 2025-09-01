package com.bayzdelivery.repositories;

import com.bayzdelivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

  @Query(value = "select d.id from delivery d  where extract( EPOCH from AGE( d.end_time , d.start_time)) / 60 > ?1", nativeQuery = true)
  List<Long> findDeliveriesExceededMinutesAllowed(Long minutesAllowed);
}
