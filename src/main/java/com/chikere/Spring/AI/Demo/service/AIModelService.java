package com.chikere.Spring.AI.Demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AIModelService {
    private final ChatClient chatClient;

    public String getResponseFromChatGPT(String prompt){
        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}
