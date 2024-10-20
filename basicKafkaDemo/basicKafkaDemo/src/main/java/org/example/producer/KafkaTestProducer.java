package org.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTestProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaTestProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        System.out.println("receinve messge is :"+message);
        kafkaTemplate.send(topic, message);
    }
}
