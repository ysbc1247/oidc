package com.projects.oidc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private Long link_id;

    @Column
    private String linkUrl;

    @ManyToOne
    @JoinColumn(name = "prompt_id", nullable = false)
    private Prompt prompt;
}
