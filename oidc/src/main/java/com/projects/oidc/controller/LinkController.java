package com.projects.oidc.controller;

import com.projects.oidc.dto.LinkDTO;
import com.projects.oidc.entity.Link;
import com.projects.oidc.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LinkController {
    private final LinkService linkService;

    @GetMapping("/link/new")
    public Link newLink(@ModelAttribute LinkDTO linkDTO){
        Long promptId = linkDTO.getPromptId();
        String link = linkDTO.getLink();
        return linkService.newLink(promptId, link);
    }
}
