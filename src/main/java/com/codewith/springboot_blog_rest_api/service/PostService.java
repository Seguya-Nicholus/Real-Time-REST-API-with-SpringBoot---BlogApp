package com.codewith.springboot_blog_rest_api.service;

import java.util.List;

import com.codewith.springboot_blog_rest_api.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
