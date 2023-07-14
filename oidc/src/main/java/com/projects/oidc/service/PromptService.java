package com.projects.oidc.service;

import com.projects.oidc.entity.Prompt;
import com.projects.oidc.entity.User;
import com.projects.oidc.repository.PromptRepository;
import com.projects.oidc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service

public class PromptService {
    private final PromptRepository promptRepository;
    private final UserRepository userRepository;
    private RestTemplate restTemplate;


    public String googleSearch(String query) {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:5000/googlesearch/" + query, String.class);
        return response.getBody();
    }

    public String generateText(User user, String prompt) {
        String apiKey = user.getApiKey();
        Map<String, String> body = new HashMap<>();
        body.put("apikey", apiKey);
        body.put("prompt", prompt);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:5000/openai",
                HttpMethod.POST,
                requestEntity,
                String.class);
        Prompt newPrompt = new Prompt();
        newPrompt.setRequest(prompt);
        newPrompt.setResponse(response.getBody());
        newPrompt.setUser(user);
        newPrompt.setCreatedAt(new Date());
        promptRepository.save(newPrompt);
        return response.getBody();
    }
}
