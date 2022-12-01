package com.example.dockerrelease.content.dao;

import com.example.dockerrelease.content.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
