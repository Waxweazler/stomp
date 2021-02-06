package de.waxweazler.stomp.controller;

import de.waxweazler.stomp.app.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class RestConfigController {

    private final ApplicationConfig applicationConfig;

    @Autowired
    RestConfigController(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @PutMapping("/message")
    public void addMessage(@RequestBody String message) {
        applicationConfig.addMessage(message);
    }

}
