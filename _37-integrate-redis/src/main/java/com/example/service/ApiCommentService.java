package com.example.service;

import com.example.domain.Comment;

public interface ApiCommentService {

    Comment findById(Integer id);

    Comment updateComment(Comment comment);

    void deleteComment(Integer id);

}
