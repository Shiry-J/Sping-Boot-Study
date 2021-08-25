package com.example.mapper;

import com.example.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getArticleById() {
        System.out.println("articleMapper.getArticleById(1) = " + articleMapper.getArticleById(1));
    }

    @Test
    void getArticleList() {
        System.out.println(articleMapper.getArticleList());
    }

    @Test
    void updateArticle() {
        Article article = new Article();
        article.setId(4);
        article.setContent("Studying Spring");
        article.setTitle("Spring Studying");
        System.out.println("update------->" + articleMapper.updateArticle(article));
    }

    @Test
    void addArticle() {
        Article article = new Article();
        article.setTitle("Processing");
        article.setContent("ing");
        System.out.println("add----------->" + articleMapper.addArticle(article));
    }

    @Test
    void delArticle() {
        System.out.println("delete-------->" + articleMapper.delArticle(4));
    }
}