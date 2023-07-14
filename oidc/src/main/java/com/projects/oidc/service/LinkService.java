package com.projects.oidc.service;

import com.projects.oidc.entity.Link;
import com.projects.oidc.entity.Prompt;
import com.projects.oidc.repository.LinkRepository;
import com.projects.oidc.repository.PromptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private final PromptRepository promptRepository;

    public Link newLink(Long promptId, String link){
        Link newLink = new Link();
        newLink.setLinkUrl(link);
        Prompt prompt = promptRepository.findById(promptId)
                .orElseThrow(() -> new RuntimeException("Prompt not found"));
        newLink.setPrompt(prompt);
        linkRepository.save(newLink);
        return newLink;

    }
}
