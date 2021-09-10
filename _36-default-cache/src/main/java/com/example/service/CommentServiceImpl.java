package com.example.service;

import com.example.domain.Comment;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;

@Service
public class CommentServiceImpl implements  CommentService {

    @Autowired
    public CommentRepository commentRepository;

    //add
    public Comment addComment(Comment comment){
        return this.commentRepository.save(comment);
    }
    //delete
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(Integer id){
        this.commentRepository.deleteById(id);
    }

    //modify
    @CachePut(cacheNames = "comment",key ="#result.id")
    public int modifyComment(Integer id,String author){
        return this.commentRepository.updateComment(author,id);
    }
    //query
    @Cacheable(cacheNames = "comment",unless = "#result==null")//创建缓存空间，并命名为comment
    public Comment findById(Integer id){
        Optional<Comment> optional = this.commentRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();

        }
        return null;
    };

}
