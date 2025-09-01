package com.bayzdelivery.jobs;

import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.service.DeliveryService;
import com.bayzdelivery.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DelayedDeliveryNotifier {

    private static final Logger LOG = LoggerFactory.getLogger(DelayedDeliveryNotifier.class);

    private NotificationService notificationService;

    private DeliveryService deliveryService;

    private Long minutesAllowedToDeliver;

    public DelayedDeliveryNotifier(NotificationService notificationService, DeliveryService deliveryService, @Value("${bayzdelivery.deliver.minutes-allowed}") Long minutesAllowedToDeliver) {
        this.notificationService = notificationService;
        this.deliveryService = deliveryService;
        this.minutesAllowedToDeliver = minutesAllowedToDeliver;
    }

    /**
     *  Use this method for the TASK 3
     */
    @Scheduled(fixedDelay = 30000)
    public void checkDelayedDeliveries() {

        List<Long> deliveriesIds = deliveryService.findLateDeliveries(minutesAllowedToDeliver);

        if(!deliveriesIds.isEmpty()) {

            notificationService.notifyLateDeliveries(deliveriesIds, minutesAllowedToDeliver);
        }
    }


    /**
     * This method should be called to notify customer support team
     * It just writes notification on console but it may be email or push notification in real.
     * So that this method should run in an async way.
     */
    @Async
    public void notifyCustomerSupport() {
        LOG.info("Customer support team is notified!");
    }
}
