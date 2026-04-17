package com.sabtok.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "sab-event", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println(message);
    }
}
