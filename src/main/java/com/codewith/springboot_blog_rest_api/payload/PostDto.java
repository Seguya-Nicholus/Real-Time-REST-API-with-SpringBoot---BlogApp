package com.codewith.springboot_blog_rest_api.payload;

import java.util.Set;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;

}
