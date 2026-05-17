package com.sabtok.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EventProcessServiceLocator {

    private Map<String, EventService> eventServiceMap = new HashMap<>();

    @Autowired
    public EventProcessServiceLocator(Set<EventService> eventServiceSet) {
        eventServiceSet.forEach(eventService -> {
            eventServiceMap.put(eventService.getEventName(),eventService);
        });
    }

    public EventService getEventService(String eventServiceName) {
        return eventServiceMap.get(eventServiceName);
    }
}
