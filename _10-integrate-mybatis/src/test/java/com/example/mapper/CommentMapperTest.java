package com.example.mapper;

import com.example.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void querryComment() {
        System.out.println("commentMapper.querryComment(1) = " + commentMapper.querryComment(1));
    }

    @Test
    void deleteComment() {
        System.out.println("delete------------->" + commentMapper.deleteComment(7));
    }

    @Test
    void updateComment() {
        Comment comment = new Comment();
        comment.setId(7);
        comment.setContent("Study in the morning");
        comment.setAuthor("Shiry_Y");
        System.out.println("update------------>" + commentMapper.updateComment(comment));
    }

    @Test
    void insertComment() {
        Comment comment = new Comment();
        comment.setContent("Study");
        comment.setAuthor("Shiry");
        comment.setArticleId(1);
        System.out.println("insert--------->" + commentMapper.insertComment(comment));
    }
}