package com.bayzdelivery.controller;

import com.bayzdelivery.dto.CreateDeliveryDTO;
import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.dto.TopDeliveryMenResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bayzdelivery.service.DeliveryService;

@RestController
@RequestMapping("/v1/delivery")
public class DeliveryController {

  private DeliveryService deliveryService;

  public DeliveryController(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }

  @PostMapping
  public DeliveryDTO createNewDelivery(@RequestBody @Valid CreateDeliveryDTO createDeliveryDTO) {

    return deliveryService.save(createDeliveryDTO);
  }

  @GetMapping(path = "/{delivery-id}")
  public DeliveryDTO getDeliveryById(@PathVariable(name="delivery-id",required=true)Long deliveryId) {
    DeliveryDTO delivery = deliveryService.findById(deliveryId);
    if (delivery != null)
      return delivery;
    return null;
  }
}
