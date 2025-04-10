package com.chikere.Spring.AI.Demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private ChatClient chatClient;

    public AIService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getTResponseFromChatGPT(String prompt){
        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}
