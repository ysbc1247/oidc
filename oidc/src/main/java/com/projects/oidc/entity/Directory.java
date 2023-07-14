package com.projects.oidc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_id")
    private Long directory_id;

    private String name;

    @OneToMany(mappedBy = "directory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Prompt> prompts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Directory parentDirectory;

    @OneToMany(mappedBy = "parentDirectory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Directory> subdirectories = new HashSet<>();

}
