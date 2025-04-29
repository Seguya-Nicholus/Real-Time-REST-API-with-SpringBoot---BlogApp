package com.codewith.springboot_blog_rest_api.payload;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
    private Long id;

    // PostTitle should not be null or empty
    // Post Title should atleast have 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have atleast 2 charcters")
    private String title;

    // Post Description should not be null or empty
    // Post Description should atleast have 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have atleast 10 charcters")
    private String description;

    // Post content should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

}
