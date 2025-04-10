package com.chikere.Spring.AI.Demo.controller;

import com.chikere.Spring.AI.Demo.service.AIService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
