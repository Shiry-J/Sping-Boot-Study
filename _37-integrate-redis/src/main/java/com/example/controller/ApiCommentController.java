package com.example.controller;

import com.example.domain.Comment;
import com.example.service.ApiCommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiCommentController {

    @Autowired
    private ApiCommentServiceImp apiCommentService;

    //query
    @GetMapping("/query/{id}")
    public Comment findById(@PathVariable("id") Integer id){
        return this.apiCommentService.findById(id);
    }

    //modify
    @GetMapping("/modify/{id}/{author}")
    public Comment modifyBy(@PathVariable("id") Integer id,@PathVariable("author") String author){
        Comment comment = new Comment();
        comment.setId(id);
        comment.setAuthor(author);
        return this.apiCommentService.updateComment(comment);
    }

    //delete
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        this.apiCommentService.deleteComment(id);
    }

    //add

}
