package com.bayzdelivery.repositories;

import com.bayzdelivery.model.Delivery;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {


  List<Delivery> findByOrderByComissionDesc(Limit limit);
}
