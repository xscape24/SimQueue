package com.simqueue.simqueue;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final SimpMessagingTemplate messagingTemplate;

    public EventService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendEvent(String message) {
        messagingTemplate.convertAndSend("/topic/events", message);
        System.out.println("Event sent: " + message);
    }
}
