package com.example.mapper;

import com.example.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 查询单文章
    Article getArticleById(int id);

    // 查询文章列表
    List<Article> getArticleList();

    // 修改文章
    int updateArticle(Article article);

    // 添加文章
    int addArticle(Article article);

    // 删除文章
    int delArticle(int id);

}
