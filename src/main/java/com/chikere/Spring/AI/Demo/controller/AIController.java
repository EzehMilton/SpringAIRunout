package com.chikere.Spring.AI.Demo.controller;

import com.chikere.Spring.AI.Demo.service.AIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AIController is a REST controller that handles API requests for interacting with an AI service.
 * It provides an endpoint to send user messages and receive AI-generated responses.
 *
 * This controller is mapped to the base path "/api/openai" and delegates processing
 * to the AIService for generating responses.
 */
@RestController
@RequestMapping("/api/openai")
public class AIController {
    private AIService aiService;
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }
    @PostMapping("/chat")
    public String getResponse(@RequestParam String message){
        return aiService.getTResponseFromChatGPT(message);
    }
}
