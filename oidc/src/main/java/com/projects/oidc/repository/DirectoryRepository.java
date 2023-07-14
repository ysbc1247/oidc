package com.projects.oidc.repository;

import com.projects.oidc.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {
}
