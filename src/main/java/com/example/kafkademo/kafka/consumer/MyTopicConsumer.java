package com.example.kafkademo.kafka.consumer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.kafkademo.kafka.configuration.Constants.KAFKA_CONSUMER_GROUP_ID;
import static com.example.kafkademo.kafka.configuration.Constants.KAFKA_TOPIC_LABEL;

@Slf4j
@Component
public class MyTopicConsumer {
    @Getter
    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = KAFKA_TOPIC_LABEL, groupId = KAFKA_CONSUMER_GROUP_ID)
    public void listen(String message) {
        messages.add(message);
        log.info("Consumer received new message: {}", message);
    }
}
