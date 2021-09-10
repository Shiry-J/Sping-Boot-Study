package com.example.service;

import com.example.domain.Comment;

public interface CommentService {
    //add
    public Comment addComment(Comment comment);
    //delete
    public void deleteComment(Integer id);

    //modify
    public Comment modifyComment(Integer id,String author);
    //query
    public Comment findById(Integer id);
}
