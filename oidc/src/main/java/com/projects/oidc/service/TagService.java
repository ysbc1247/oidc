package com.projects.oidc.service;

import com.projects.oidc.entity.Prompt;
import com.projects.oidc.entity.PromptTag;
import com.projects.oidc.entity.Tag;
import com.projects.oidc.repository.PromptRepository;
import com.projects.oidc.repository.PromptTagRepository;
import com.projects.oidc.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class TagService {
    private final TagRepository tagRepository;
    private final PromptRepository promptRepository;
    private final PromptTagRepository promptTagRepository;

    public Tag newTag(String tag){
        Tag newTag = new Tag();
        newTag.setTagName(tag);
        tagRepository.save(newTag);
        return newTag;
    }

    public PromptTag linkTagToPrompt(Long promptId, Long tagId){
        PromptTag promptTag = new PromptTag();

        Prompt prompt = promptRepository.findById(promptId)
                .orElseThrow(() -> new RuntimeException("Prompt not found"));
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new RuntimeException("Tag not found"));

        promptTag.setPrompt(prompt);
        promptTag.setTag(tag);

        return promptTagRepository.save(promptTag);
    }

}
