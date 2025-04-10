package com.chikere.Spring.AI.Demo.tools;

import org.springframework.ai.tool.annotation.Tool;

/**
 * AITools is a utility class that provides tools to be used in AI functionalities within the application.
 * It is intended to integrate specific tools that can enhance the behavior of AI models or systems.
 *
 * One of the main objectives of AITools is to define callable tools that can be invoked during AI operations,
 * and these tools are aimed at augmenting the functionality of AI systems by providing predefined responses
 * or executing specific tasks.
 */
public class AITools {
    // When called with http://localhost:8080/api/openai/chat?message=Give me text by calling tool to help me create it, it will add <This is a tool> in the
    // model's response
    @Tool(description = "Call the tool to help me create it")
    public String testTools(){
        return "This is a tool";
    }
}
