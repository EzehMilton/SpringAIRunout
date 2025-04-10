package com.chikere.Spring.AI.Demo.service;

import lombok.extern.slf4j.Slf4j;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Slf4j
public class AIModelService {
    private final ChatClient chatClient;
    private final MeterRegistry meterRegistry;

    public String getResponseFromChatGPT(String prompt) {
        // start timing the request duration
        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            log.info("Connecting to chatGPT");
            var response = getChatResponse(prompt);
            recordMetrics(sample);
            log.info("Response from chatGPT: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Error in chatGPT", e);
            recordMetrics(sample);
            throw e;
        }
    }

    private void recordMetrics(Timer.Sample sample) {
        // record request duration
        sample.stop(meterRegistry.timer("ai.request.duration",
                "status", "success"));
        // record request count
        meterRegistry.counter("ai.request.count",
                "status", "success").increment();
    }

    private String getChatResponse(String prompt) {
        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}
