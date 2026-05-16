package com.sabtok.events;

public interface EventService {

    String getEventName();

    void processEvent(String message);
}
