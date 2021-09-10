package com.example.service;

import com.example.domain.Comment;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentServiceImpl implements  CommentService {

    @Autowired
    public CommentRepository commentRepository;

    //add
    @Transactional
    public Comment addComment(Comment comment){
        return this.commentRepository.save(comment);
    }
    //delete
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(Integer id){
        this.commentRepository.deleteById(id);
    }

    //modify
    @Transactional
    @CachePut(cacheNames = "comment",key ="#result.id")
    public Comment modifyComment(Integer id,String author){
        int i = this.commentRepository.updateComment(author, id);
        if (i==1){
            Optional<Comment> optionalComment = this.commentRepository.findById(id);
            if (optionalComment.isPresent()){
                Comment comment = optionalComment.get();
                return comment;
            }
        }
        return null;
    }
    //query
    @Transactional
    @Cacheable(cacheNames = "comment",unless = "#result==null")//创建缓存空间，并命名为comment
    public Comment findById(Integer id){
        Optional<Comment> optional = this.commentRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();

        }
        return null;
    };

}
