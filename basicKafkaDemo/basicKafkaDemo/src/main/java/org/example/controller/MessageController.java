package org.example.controller;

import org.example.producer.KafkaTestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final KafkaTestProducer kafkaProducer;

    @Autowired
    public MessageController(KafkaTestProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestParam String topic, @RequestBody String message) {
        kafkaProducer.sendMessage(topic, message);
    }
}
