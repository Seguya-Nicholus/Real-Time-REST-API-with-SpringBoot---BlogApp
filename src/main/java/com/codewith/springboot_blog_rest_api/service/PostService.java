package com.codewith.springboot_blog_rest_api.service;

import java.util.List;

import com.codewith.springboot_blog_rest_api.payload.PostDto;
import com.codewith.springboot_blog_rest_api.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
