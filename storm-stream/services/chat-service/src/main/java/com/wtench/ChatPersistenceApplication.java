package com.wtench;

import com.wtench.domain.ChatMessage;
import com.wtench.response.MessageDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableKafka
@EnableJpaRepositories
public class ChatPersistenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatPersistenceApplication.class, args);
    }
}
