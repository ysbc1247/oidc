package com.projects.oidc.controller;

import com.projects.oidc.entity.PromptTag;
import com.projects.oidc.entity.Tag;
import com.projects.oidc.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TagController {
    private final TagService tagService;

    @PostMapping("/tag/new")
    public Tag newTag(String tag){
        return tagService.newTag(tag);
    }

    @GetMapping("/tag/link/{promptId}/{tagId}")
    public PromptTag linkTagToPrompt(@PathVariable Long promptId, @PathVariable Long tagId){
        return tagService.linkTagToPrompt(promptId, tagId);
    }
}
