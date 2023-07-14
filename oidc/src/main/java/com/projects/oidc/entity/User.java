package com.projects.oidc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Table
@Entity
public class User {
    @Id
    @Column(name = "userId", length = 50)
    private String userId;

    @Column
    private String password;

    @Column
    private String apiKey;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Prompt> prompts = new HashSet<>();
    public static User of(String userId, String userPassword, String apiKey) {
        return User.of(userId, userPassword, apiKey);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User that)) return false;
        return this.getUserId() != null && this.getUserId().equals(that.getUserId());
    }




    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }

}
