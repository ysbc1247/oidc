package com.projects.oidc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class PromptTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prompttag_id")
    private Long promptTag_id;

    @ManyToOne
    @JoinColumn(name = "prompt_id", nullable = false)
    private Prompt prompt;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
