package com.microservice.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqMessageProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqMessageProducer.class);

  private final AmqpTemplate amqpTemplate;

  public RabbitMqMessageProducer(@Autowired AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  public void publish(Object payload, String exchange, String routingKey) {
    LOGGER.info("Publishing to {} using routing {}. Payload {}", exchange, routingKey, payload);
    amqpTemplate.convertAndSend(exchange, routingKey, payload);
    LOGGER.info("Published to {} using routing {}. Payload {}", exchange, routingKey, payload);
  }

}
