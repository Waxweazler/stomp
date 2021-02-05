package de.tjoe.stomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private static final String TOPIC_DESTINATION = "/topic/destination";

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @SubscribeMapping(TOPIC_DESTINATION)
    public String onSubscribe() {
        return "SUBSCRIBED :)";
    }

    public void broadcast() {
        this.template.convertAndSend(TOPIC_DESTINATION, "BROADCAST :)");
    }

}
