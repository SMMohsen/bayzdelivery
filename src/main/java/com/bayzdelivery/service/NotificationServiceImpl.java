package com.bayzdelivery.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class NotificationServiceImpl implements NotificationService {

  private final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

  @Async
  @Override
  public void notifyLateDeliveries(List<Long> deliverIds, Long minutesAllowed) {


    logger.info("please be aware that these deliveries Ids {} are took more than {} minutes to be delivered",deliverIds, minutesAllowed);
  }
}
