package com.example.kafkademo.controller;

import com.example.kafkademo.kafka.consumer.MyTopicConsumer;
import com.example.kafkademo.kafka.producer.MyTopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class DemoController {

    @Autowired
    private MyTopicConsumer consumer;

    @Autowired
    private MyTopicProducer producer;

    @GetMapping("/produce")
    public void produce(@RequestParam String message) {
        producer.produce(message);
    }

    @GetMapping("/messages")
    public List<String> produce() {
        return consumer.getMessages();
    }
}
