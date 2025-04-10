package com.chikere.Spring.AI.Demo.tools;

import org.springframework.ai.tool.annotation.Tool;

public class AITools {
    private static final String DEFAULT_TOOL_MESSAGE = "This is the tool that I will call";
    @Tool(name = "get_tool_response_message", description = "Call the tool to help me create it")
    public String getToolResponseMessage(){
        return DEFAULT_TOOL_MESSAGE;
    }
}
