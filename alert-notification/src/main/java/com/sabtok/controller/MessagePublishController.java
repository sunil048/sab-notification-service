package com.sabtok.controller;

import com.sabtok.service.SaveIncomingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/notification")
public class MessagePublishController {

    private static final String TOPIC = "sab-event";
    private static final String KEY = "Log";

    @Autowired
    private SaveIncomingLog incomingLog;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public String postMessage(@RequestBody String message) {

        CompletableFuture<SendResult<String, String>> future
                = this.kafkaTemplate.send(TOPIC, KEY, message);

        final AtomicReference<String> response = new AtomicReference<>();
        future.whenComplete((result, throwable) -> {
            if (throwable != null) {
                //logger.error("Unable to send message : " + message, throwable);
                response.set("Unable to send message : " + message);
            } else {
                //logger.info("Sent message: " + message + " with offset: " + result.getRecordMetadata().offset());
                response.set("Sent message: " + message + " with offset: " + result.getRecordMetadata().offset());
            }
        });
        return response.get();
    }

    @GetMapping("/logs")
    public Object getMessageList(){
        return incomingLog.getAllLogs();
    }
}
