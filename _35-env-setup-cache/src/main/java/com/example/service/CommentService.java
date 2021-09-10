package com.example.service;

import com.example.domain.Comment;

import java.util.Optional;

public interface CommentService {
    //add
    public Comment addComment(Comment comment);
    //delete
    public void deleteComment(Integer id);

    //modify
    public int modifyComment(Integer id,String author);
    //query
    public Comment findById(Integer id);
}
