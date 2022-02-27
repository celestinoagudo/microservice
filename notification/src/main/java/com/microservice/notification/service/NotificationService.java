package com.microservice.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.notification.model.Notification;
import com.microservice.notification.repository.NotificationRepository;

@Service
public class NotificationService {

  private NotificationRepository notificationRepository;

  public NotificationService(@Autowired NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  public void sendNotification(Notification notification) {
    notificationRepository.save(notification);
  }
}
