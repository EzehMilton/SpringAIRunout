package com.chikere.Spring.AI.Demo.config;

import com.chikere.Spring.AI.Demo.tools.AITools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration class is responsible for setting up and providing beans related to AI functionalities.
 * It defines the configuration for creating a chat client with predefined system behaviors, tools, and advisors.
 */
@Configuration
public class AIModelConfiguration {

    /**
     * Creates and configures a ChatClient bean with default options, system prompts, tools, and advisors.
     *
     * ChatClient is an interface that serves as an abstraction layer for interacting with various AI chat models like OpenAI's GPT models.
     * It provides a unified way to:
     * 1. Send Prompts to AI Models
     * 2. Configure model parameters / options, e.g. temperature, max tokens, etc.
     * 3. Manage Chat Memory, RAG, logging etc
     * 4. Add custom tools to the chat client to extenbd its capabilities
     * @param chatClientBuilder the builder instance used to construct the ChatClient with specified configuration
     * @return an instance of ChatClient configured with default options, system prompt, tools, and advisors
     */
    @Bean
    ChatClient chatClient(ChatClient.Builder chatClientBuilder){ // Uses builder design pattern to construct the ChatClient
        return chatClientBuilder
//                .defaultOptions(ChatOptions.builder()
//                        .model("gpt-4o-mini") // set model to use
//                        .temperature(0.1) // set temperature, the lower, the more deterministic, focused responses, higher more creative - 0.1 - 0.9
//                        .maxTokens(1000) // maximum length of response
//                        .build())
                .defaultSystem("You are a helpful assistant that provides excellent answers. Always think step by step.") // set system prompt
                .defaultTools(new AITools()) // add tool to call
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()), getSimpleLoggerAdvisor()) // set chat memory and logging
                .build();
    }

    private static SimpleLoggerAdvisor getSimpleLoggerAdvisor() {
        return new SimpleLoggerAdvisor(
        );

    }

    // when you need to convert this into an MCP server
//    @Bean
//    ToolCallbackProvider tools (AITools aiTools){
//        return MethodToolCallbackProvider.builder()
//                .toolObjects(aiTools)
//                .build();
//    }
}
