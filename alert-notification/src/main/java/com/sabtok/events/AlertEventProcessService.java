package com.sabtok.events;

import com.sabtok.messaging.service.SabPublishNotification;
import com.sabtok.service.SabNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sabtok.model.EventType.ALERT;

@Service
@RequiredArgsConstructor
public class AlertEventProcessService implements EventService{

    @Autowired
    private SabPublishNotification sabPublishNotification;

    @Override
    public String getEventName() {
        return ALERT.name();
    }

    @Override
    public void processEvent(String message) {
        System.out.println("Processing alert event");
        this.sabPublishNotification.publishNotificationEvent("alert-process-topic", message);
    }
}
