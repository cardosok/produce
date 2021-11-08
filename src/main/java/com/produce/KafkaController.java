package com.produce;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    private final Producer topicProducer;

    @GetMapping(value = "/send")
    public ResponseEntity send(){
        Produto produto = Produto.builder()
                .codigo(new Random().nextInt(1000))
                .nome("Produto "+ new Random().nextInt(1000))
                .preco(Long.valueOf(new Random().nextInt(10000)))
                .build();

        topicProducer.send(produto);
        return ResponseEntity.ok(produto);
    }
}