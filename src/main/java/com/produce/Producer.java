package com.produce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String,Produto > kafkaTemplate;

    public void send(Produto message){
        log.info("Payload enviado: " +  message);
        kafkaTemplate.send(topicName, message);
    }
}
