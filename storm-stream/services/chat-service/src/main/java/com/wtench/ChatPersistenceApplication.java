package com.wtench;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ChatPersistenceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ChatPersistenceApplication.class, args);
    }
}
