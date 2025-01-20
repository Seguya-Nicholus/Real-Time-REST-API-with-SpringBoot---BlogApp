package com.codewith.springboot_blog_rest_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewith.springboot_blog_rest_api.payload.PostDto;
import com.codewith.springboot_blog_rest_api.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Create Blog Post Api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){

        return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);

    }

    // Get all posts
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    // Get Post by Id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<PostDto>(postService.getPostById(id), HttpStatus.OK);
    }


    // update post by Id 
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id")long id){

       PostDto postResponse = postService.updatePost(postDto, id);
       return new ResponseEntity<>(postResponse, HttpStatus.OK);

    }


}
