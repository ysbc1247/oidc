package com.projects.oidc.repository;

import com.projects.oidc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
    void deleteByUserId(String userId);
}
