package com.example.repository;

import com.example.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void findAll() {
        System.out.println(commentRepository.findAll());
    }

    @Test
    void findById() {
        System.out.println("commentRepository.findById(1) = " + commentRepository.findById(1));
    }

    @Test
    void existsById() {
        System.out.println("commentRepository.existsById(1) = " + commentRepository.existsById(1));
    }

    @Test
    void count() {
        System.out.println("commentRepository.count() = " + commentRepository.count());
    }

    @Test
    void getCommentList(){
        System.out.println(commentRepository.getCommentList(1));
    }

    @Test
    void getCommentListNoNative(){
        System.out.println(commentRepository.getCommentListNoNative(1));
    }

    @Test
    void updateComment(){
        System.out.println(commentRepository.updateComment("6666", 4));
    }

    @Test
    void deleteComment(){
        System.out.println(commentRepository.deleteComment(8));
    }

    @Test
    void save(){
        Comment comment = new Comment();
        comment.setAuthor("learn");
        comment.setContent("content");
        comment.setArticleId(1);
        System.out.println(commentRepository.save(comment));
    }
}