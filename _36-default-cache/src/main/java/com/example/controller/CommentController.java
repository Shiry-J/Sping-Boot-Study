package com.example.controller;

import com.example.domain.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    //query
    @GetMapping("/query/{id}")
    public Comment findById(@PathVariable("id") Integer id){
        return this.commentService.findById(id);
    }

    //modify
    @GetMapping("/modify/{id}/{author}")
    public int modifyBy(@PathVariable("id") Integer id,@PathVariable("author") String author){
        int i = this.commentService.modifyComment(id, author);
        return i;
    }

    //delete
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        this.commentService.deleteComment(id);
    }

    //add

}
