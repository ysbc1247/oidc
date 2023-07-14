package com.projects.oidc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Prompt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prompt_id")
    private Long prompt_id;

    @Column
    private String request;

    @Column
    private String response;

    @Column
    private Date createdAt;

    @OneToMany(mappedBy = "prompt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PromptTag> promptTags = new HashSet<>();

    @OneToMany(mappedBy = "prompt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Link> links = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "directory_id", nullable = false)
    private Directory directory;


}
