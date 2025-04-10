package com.chikere.Spring.AI.Demo.controller;

import com.chikere.Spring.AI.Demo.service.AIModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/openai")
public class AIModelController {
    private final AIModelService aiService;

    @PostMapping("/chat")
    public String processChatRequest(@RequestParam String prompt){
        return aiService.getResponseFromChatGPT(prompt);
    }
}
