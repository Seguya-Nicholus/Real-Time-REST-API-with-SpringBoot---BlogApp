package com.codewith.springboot_blog_rest_api.service;

import com.codewith.springboot_blog_rest_api.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto); 

}
