package com.chikere.Spring.AI.Demo.tools;

import org.springframework.ai.tool.annotation.Tool;

public class AITools {
    // When called with http://localhost:8080/api/openai/chat?message=Give me text by calling tool to help me create it, it will add <This is a tool> in the
    // model's response
    @Tool(description = "Call the tool to help me create it")
    public String testTools(){
        return "This is a tool";
    }
}
