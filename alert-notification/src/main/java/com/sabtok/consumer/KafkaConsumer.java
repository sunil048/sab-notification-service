package com.sabtok.consumer;

import com.sabtok.records.MessageLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "sab-event", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println(message);
        MessageLog messageLog = new MessageLog(1,message, LocalDateTime.now(),"alert-notification");
    }
}
