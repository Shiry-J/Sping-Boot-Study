package com.example.service;

import ch.qos.logback.core.util.TimeUtil;
import com.example.domain.Comment;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class ApiCommentServiceImp implements ApiCommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired  // 引入 RedisTemplate
    private RedisTemplate redisTemplate;

    /**
     * 查询方法
     */

    public Comment findById(Integer id){
        //先到缓存中查询
        Comment comment = (Comment) redisTemplate.opsForValue().get("comment_" + id);
        if(comment!=null){
            //缓存中有数据
            return  comment;
        }else{//缓存中没有数据
            //到数据库中进行查询
            Optional<Comment> byId = commentRepository.findById(id);
            if(byId.isPresent()){
                //若是数据库中存在，将数据先存入redis
                Comment comment1 = byId.get();
                redisTemplate.opsForValue().set("comment_"+id,comment1,1, TimeUnit.DAYS);
                return comment1;
            }
            System.out.println("缓存中没有数据的情况下，数据库中也没有");
            return null;
        }

    }

    /**
     * 更新方法
     */
    public Comment updateComment(Comment comment){
        //更新mysql数据库
        int i = commentRepository.updateComment(comment.getAuthor(), comment.getId());
        if (i==1){
            Comment comment1 = this.findById(comment.getId());
            //更新redis缓存
            redisTemplate.opsForValue().set("comment_"+comment1.getId(),comment1);
            //更新后进行查询
            return comment1;
        }
        return null;
    }

    /**
     * 删除方法
     */
    public void deleteComment(Integer id){
        //删除 mysql 数据库中的数据
        commentRepository.deleteById(id);
        //删除redis缓存中的数据
        redisTemplate.delete("comment_" + id);
    }



}