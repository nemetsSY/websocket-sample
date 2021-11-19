package com.andersenlab.example.ws1;

import java.util.Map;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/topic/{all}")
    @SendTo("/topic/special")
    public Map<String, String> handleMessage(@Payload String message, @Header("destination") String destination, @DestinationVariable("all") String dest) {
        System.out.println("message = " + message + ", destination = " + destination);
        return Map.of("message", message, "destination", destination);
    }

}
