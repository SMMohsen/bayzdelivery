package com.bayzdelivery.service;

import java.util.List;

public interface NotificationService {

  void notifyLateDeliveries(List<Long> deliverIds, Long minutesAllowed);
}
