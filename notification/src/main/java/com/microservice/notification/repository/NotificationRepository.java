package com.microservice.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.notification.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
