package com.example.dockerrelease.controller;

import com.example.dockerrelease.dao.ArticleRepository;
import com.example.dockerrelease.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping("")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

}
