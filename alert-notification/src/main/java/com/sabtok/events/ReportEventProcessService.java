package com.sabtok.events;


import com.sabtok.convertor.NotificationMessageConvertor;
import com.sabtok.messaging.service.SabPublishNotification;
import com.sabtok.request.ReportCreationRequest;
import com.sabtok.service.JSONHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sabtok.model.EventType.REPORT;

@Service
public class ReportEventProcessService implements EventService {

    @Autowired
    private SabPublishNotification sabPublishNotification;

    @Override
    public String getEventName() {
        return REPORT.name();
    }

    @Override
    public void processEvent(String message) {
        ReportCreationRequest reportCreationRequest = new NotificationMessageConvertor()
                .getReportCreationRequestFromMessage(message);
        String reportCreationRequestString = new JSONHandler().toJson(reportCreationRequest, ReportCreationRequest.class);
        this.sabPublishNotification.publishNotificationEvent("report-process-topic",reportCreationRequestString);
    }
}
