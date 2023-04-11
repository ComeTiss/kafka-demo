package com.example.kafkademo.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.example.kafkademo.kafka.configuration.Constants.KAFKA_TOPIC_LABEL;

@Component
public class MyTopicProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void produce(String message) {
        kafkaTemplate.send(KAFKA_TOPIC_LABEL, message);
    }
}
