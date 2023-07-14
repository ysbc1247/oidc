package com.projects.oidc.repository;

import com.projects.oidc.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
