package com.microservice.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

  @Value("${rabbitmq.exchanges.internal}")
  private String internalExchange;

  @Value("${rabbitmq.routing-keys.internal-notification}")
  private String internalNotificationRoutingKey;

  @Value("${rabbitmq.queue.notification}")
  private String notificationQueue;

  public synchronized String getInternalExchange() {
    return internalExchange;
  }

  public synchronized String getInternalNotificationRoutingKey() {
    return internalNotificationRoutingKey;
  }

  public synchronized String getNotificationQueue() {
    return notificationQueue;
  }

  @Bean
  public Binding internalToNotificationBinding() {
    return BindingBuilder.bind(notificationQueue()).to(internalTopicExchange())
        .with(internalNotificationRoutingKey);
  }

  @Bean
  public TopicExchange internalTopicExchange() {
    return new TopicExchange(internalExchange);
  }

  @Bean
  public Queue notificationQueue() {
    return new Queue(notificationQueue);
  }
}
