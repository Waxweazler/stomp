package de.waxweazler.stomp.controller;

import de.waxweazler.stomp.app.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;
    private final ApplicationConfig applicationConfig;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template, ApplicationConfig applicationConfig) {
        this.template = template;
        this.applicationConfig = applicationConfig;

        this.applicationConfig.onMessage(this::broadcast);
    }

    private void broadcast(String message) {
        this.template.convertAndSend("/topic/list", message);
    }

}
