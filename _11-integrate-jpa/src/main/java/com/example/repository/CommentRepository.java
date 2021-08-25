package com.example.repository;

import com.example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Override
    List<Comment> findAll();

    @Override
    Optional<Comment> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();


    @Query(value = "select * from b_comment where article_id =?1" ,nativeQuery = true)
    List<Comment> getCommentList(Integer articleId);

    @Query(value = "select c from b_comment c where c.articleId = ?1" ,nativeQuery = false)
    List<Comment> getCommentListNoNative(Integer articleId);

    @Transactional
    @Modifying
    @Query(value = "update b_comment set author = ?1 where id = ?2" ,nativeQuery = true)
    int updateComment(String author,Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from b_comment where id = ?1" ,nativeQuery = true)
    int deleteComment(Integer id);

    @Override
    <S extends Comment> S save(S s);

}
