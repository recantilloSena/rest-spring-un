package com.api.rest.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private final Client client;

    // Inyección por constructor (Buena práctica)
    public GeminiService(Client client) {
        this.client = client;
    }

    public String generarRespuesta(String prompt) {
        try {
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.0-flash", 
                    prompt, 
                    null
            );
            return response.text();
        } catch (Exception e) {
            return "Error al conectar con Gemini: " + e.getMessage();
        }
    }
}