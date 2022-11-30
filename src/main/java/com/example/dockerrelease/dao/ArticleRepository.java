package com.example.dockerrelease.dao;

import com.example.dockerrelease.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
