package com.example.mapper;

import com.example.domain.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {

    //查询
    @Select("select * from b_comment where id = #{id}")
    public Comment querryComment(Integer id);

    //删除
    @Delete("delete from b_comment where id=#{id}")
    public int deleteComment(Integer id);

    //修改
    @Update("update b_comment set content = #{content}, author = #{author}  where id = #{id}")
    public int updateComment(Comment comment);

    //添加
    @Insert("insert into b_comment(content,author,article_id) values(#{content},#{author},#{articleId})")
    public int insertComment(Comment comment);


}
