package com.projects.oidc.dto;

import com.projects.oidc.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromptDTO {
    private User user;

    private String prompt;
}
