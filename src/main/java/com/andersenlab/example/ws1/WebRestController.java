package com.andersenlab.example.ws1;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebRestController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebRestController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PutMapping
    public ResponseEntity<Void> sendMessage(@RequestBody String message) {
        simpMessagingTemplate.convertAndSend("/topic/special", message);
        return ResponseEntity.ok().build();
    }
}
