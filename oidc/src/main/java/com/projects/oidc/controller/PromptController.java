package com.projects.oidc.controller;

import com.projects.oidc.dto.PromptDTO;
import com.projects.oidc.entity.User;
import com.projects.oidc.service.PromptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class PromptController {
    private final PromptService promptService;

    @GetMapping("/prompt/new")
    public String newPrompt(@ModelAttribute PromptDTO promptDTO){
        User user = promptDTO.getUser();
        String prompt = promptDTO.getPrompt();
        return promptService.generateText(user,prompt);
    }


}
