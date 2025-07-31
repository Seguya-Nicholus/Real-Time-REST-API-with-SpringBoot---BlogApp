package com.codewith.springboot_blog_rest_api.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Api(value = "Comment model information")
@Data
public class CommentDto {

     @ApiModelProperty(value = "Comment id")
    private long id;

    @ApiModelProperty(value = "Comment name")
    // name should not be null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;


    @ApiModelProperty(value = "Comment email")
    //email should not be null or empty
    // email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // comment body should not be empty
    // comment body should have a minimum of 10 characters
    @NotEmpty(message = "Comment body should not be null or empty")
    @ApiModelProperty(value = "Comment body")
    @Size(min = 10, message = "Comment body should have a minimum of 10 characters")
    private String body;

}
