package com.chikere.Spring.AI.Demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/**
 * AIService is a service layer class that integrates with a ChatClient for
 * interacting with an AI-based chat service, such as ChatGPT.
 *
 * This service provides functionality to send prompts to the chat client and
 * retrieve generated responses based on the input.
 *
 * Dependencies:
 * - ChatClient: A client interface for communication with the underlying AI service.
 */
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
