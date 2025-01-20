package com.codewith.springboot_blog_rest_api.service;

import com.codewith.springboot_blog_rest_api.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
