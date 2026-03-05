package com.api.rest;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Bean
    public Client geminiClient() {
        // Configuramos el cliente usando la API Key de Google AI Studio
        return Client.builder()
                .apiKey(apiKey)
                .build();
    }
}
