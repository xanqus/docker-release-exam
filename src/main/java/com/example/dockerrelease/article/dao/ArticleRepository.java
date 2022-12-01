package com.example.dockerrelease.article.dao;

import com.example.dockerrelease.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
