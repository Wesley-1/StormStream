package com.wtench;

import com.wtench.services.ChatService;

public class Game {
    public static void main(String[] args) {
        enableMicroservices();
    }

    private static void enableMicroservices() {
        ChatPersistenceApplication.main(new String[]{});
    }
}
