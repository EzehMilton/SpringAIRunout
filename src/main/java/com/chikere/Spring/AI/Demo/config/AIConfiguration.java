package com.chikere.Spring.AI.Demo.config;

import com.chikere.Spring.AI.Demo.tools.AITools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration class is responsible for setting up and providing beans related to AI functionalities.
 * It defines the configuration for creating a chat client with predefined system behaviors, tools, and advisors.
 */
@Configuration
public class AIConfiguration {

    @Bean
    ChatClient chatClient(ChatClient.Builder chatClientBuilder){
        return chatClientBuilder
                .defaultSystem("Act as an expert") // set system prompt
                .defaultTools(new AITools()) // add tool to call
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()), new SimpleLoggerAdvisor()) // set chat memory and logging
                .build();
    }

    // when you need to convert this into an MCP server
//    @Bean
//    ToolCallbackProvider tools (AITools aiTools){
//        return MethodToolCallbackProvider.builder()
//                .toolObjects(aiTools)
//                .build();
//    }
}
