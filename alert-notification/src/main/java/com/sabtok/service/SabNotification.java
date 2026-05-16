package com.sabtok.service;


import com.sabtok.config.KafkaConfigHolder;
import com.sabtok.messaging.service.IKafkaMsgPublisherErrorHandler;
import com.sabtok.messaging.service.KafkaNotificationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.kafka.core.KafkaTemplate;

@ConditionalOnExpression("${sabtok.notification.enabled:true}")
@ConditionalOnBean(KafkaNotificationService.class)
public class SabNotification extends KafkaNotificationService {
    protected SabNotification(KafkaTemplate<String, String> kafkaTemplate, KafkaConfigHolder kafkaConfigHolder, IKafkaMsgPublisherErrorHandler kafkaMsgPublisherErrorHandler) {
        super(kafkaTemplate, kafkaConfigHolder, kafkaMsgPublisherErrorHandler);
    }
}
