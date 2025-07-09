package com.java.kconnect.controller;

import com.java.kconnect.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private Producer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message, @RequestParam("key") String key) {
        messageProducer.sendMessage(key, message);
        return "Message sent: " + message;
    }

}
