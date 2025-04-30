package com.codewith.springboot_blog_rest_api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {

    private long id;

    // name should not be null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    //email should not be null or empty
    // email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // comment body should not be empty
    // comment body should have a minimum of 10 characters
    @NotEmpty(message = "Comment body should not be null or empty")
    @Size(min = 10, message = "Comment body should have a minimum of 10 characters")
    private String body;

}
