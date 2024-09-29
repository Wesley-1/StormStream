package com.wtench;

import com.wtench.controller.ChatController;
import com.wtench.domain.ChatMessage;
import com.wtench.response.MessageDTO;
import com.wtench.services.ChatService;
import com.wtench.services.KafkaNotificationService;
import com.wtench.util.ChatProvider;
import lombok.SneakyThrows;
import org.aspectj.bridge.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public static void main(String[] args) {
        enableMicroservices();
        Thread.startVirtualThread(() -> {
            while (true) {
                try {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    ChatProvider.post(ChatMessage.builder().message("Hi: " + random.nextInt(0, 1000)).build());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(ChatProvider.get().getBody());
            }
        });
     }

    private static void enableMicroservices() {
        ChatPersistenceApplication.main(new String[]{});
    }
}
