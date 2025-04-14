package com.codewith.springboot_blog_rest_api.service;

import java.util.List;

import com.codewith.springboot_blog_rest_api.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto); 

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

}
