package com.microservice.notification.service;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.clients.model.NotificationRequest;
import com.microservice.notification.model.Notification;

@Service
public class NotificationConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

  private final NotificationService notificationService;

  @Autowired
  public NotificationConsumer(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @RabbitListener(queues = "${rabbitmq.queue.notification}")
  public void consumer(NotificationRequest notificationRequest) {

    LOGGER.info("Consumed {} from queue", notificationRequest);
    notificationService.sendNotification(new Notification(notificationRequest.getMessage(),
        notificationRequest.getRecepientCustomerEmail(), notificationRequest.getSender(),
        LocalDateTime.now(), notificationRequest.getToCustomerId()));

  }

}
