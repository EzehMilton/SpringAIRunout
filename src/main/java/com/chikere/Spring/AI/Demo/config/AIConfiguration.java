package com.chikere.Spring.AI.Demo.config;

import com.chikere.Spring.AI.Demo.tools.AITools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfiguration {

    @Bean
    ChatClient chatClient(ChatClient.Builder chatClientBuilder){
        return chatClientBuilder
                .defaultSystem("Act as an expert") // set system prompt
                .defaultTools(new AITools()) // add tool to call
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()), new SimpleLoggerAdvisor()) // set memory and logging
                .build();
    }
}
