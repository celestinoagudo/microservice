package com.microservice.notification.controller;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.clients.model.NotificationRequest;
import com.microservice.notification.model.Notification;
import com.microservice.notification.service.NotificationService;

@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

  private final NotificationService notificationService;

  public NotificationController(@Autowired NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping
  public void sendNotification(@RequestBody NotificationRequest notificationRequest) {

    LOGGER.info("Send notification request for customer with id: {}",
        notificationRequest.getToCustomerId());

    Notification notification = new Notification(notificationRequest.getMessage(),
        notificationRequest.getRecepientCustomerEmail(), notificationRequest.getSender(),
        LocalDateTime.now(), notificationRequest.getToCustomerId());

    notificationService.sendNotification(notification);
  }

}
