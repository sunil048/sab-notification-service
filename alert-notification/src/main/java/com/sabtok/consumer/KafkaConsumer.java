package com.sabtok.consumer;

import com.sabtok.events.AlertEventProcessService;
import com.sabtok.listner.BaseMessageListner;
import com.sabtok.records.MessageLog;
import com.sabtok.service.SaveIncomingLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class KafkaConsumer extends BaseMessageListner {

    @Autowired
    private SaveIncomingLog saveIncomingLog;

    @Autowired
    private AlertEventProcessService alertEventProcessService;

   /* @KafkaListener(topics = "sab-event", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println(message);
        MessageLog messageLog = new MessageLog(message, "alert-notification");
        saveIncomingLog.saveLog(messageLog);
    }*/

    @KafkaListener(topics = "sab-event",
            groupId = "sab-notification-service")
    public void consumeMessage(String message) {
        System.out.println(message);
        alertEventProcessService.processEvent(message);

    }
}
