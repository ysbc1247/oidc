package com.projects.oidc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service

public class PromptService {
    private RestTemplate restTemplate;

    public PromptService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String googleSearch(String query) {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:5000/googlesearch/" + query, String.class);
        return response.getBody();
    }

    public String generateText(String apiKey, String prompt) {
        Map<String, String> body = new HashMap<>();
        body.put("apikey", apiKey);
        body.put("prompt", prompt);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:5000/openai",
                HttpMethod.POST,
                requestEntity,
                String.class);

        return response.getBody();
    }
}
