package com.projects.oidc.controller;

import com.projects.oidc.service.PromptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class PromptController {
    private final PromptService promptService;

    

}
