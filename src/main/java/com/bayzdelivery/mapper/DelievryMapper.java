package com.bayzdelivery.mapper;

import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.model.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DelievryMapper {

  DeliveryDTO toDTO(Delivery delivery);

  Delivery toEntity(DeliveryDTO dto);

  Delivery toEntity(CreateDeliveryDTO createDeliveryDTO);
}
