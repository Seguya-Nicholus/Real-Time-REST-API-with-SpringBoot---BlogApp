package com.codewith.springboot_blog_rest_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewith.springboot_blog_rest_api.payload.PostDto;
import com.codewith.springboot_blog_rest_api.payload.PostResponse;
import com.codewith.springboot_blog_rest_api.service.PostService;
import com.codewith.springboot_blog_rest_api.utils.AppConstants;

import jakarta.validation.Valid;

@RestController // @Controller, @ResponseBody
@RequestMapping("/api/v1/posts") // baseUrl
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

     @PreAuthorize("hasRole('ADMIN')")

    // Create Blog Post Api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){

        return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);

    }

    // Get all posts
    @GetMapping
    public PostResponse getAllPosts(
        @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
        @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // Get Post by Id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<PostDto>(postService.getPostById(id), HttpStatus.OK);
    }


    // update post by Id 
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id")long id){

       PostDto postResponse = postService.updatePost(postDto, id);
       return new ResponseEntity<>(postResponse, HttpStatus.OK);

    }


    // delete post by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id")long id){
        postService.deletePostById(id);

        return new ResponseEntity<>("Post Entity deleted Successfully",HttpStatus.OK);
    }


}
