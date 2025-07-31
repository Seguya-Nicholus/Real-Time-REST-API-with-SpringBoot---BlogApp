package com.codewith.springboot_blog_rest_api.payload;

import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@ApiModel(description = "Post model information")
@Data
public class PostDto {

    @ApiModelProperty(value = "Blog post id")
    private Long id;

    // PostTitle should not be null or empty
    // Post Title should atleast have 2 characters
    @ApiModelProperty(value = "Blog post title")
    @NotEmpty
    @Size(min = 2, message = "Post title should have atleast 2 charcters")
    private String title;

    // Post Description should not be null or empty
    // Post Description should atleast have 10 characters
    @ApiModelProperty(value = "Blog post description")
    @NotEmpty
    @Size(min = 10, message = "Post description should have atleast 10 charcters")
    private String description;

    // Post content should not be null or empty
    @ApiModelProperty(value = "Blog post content")
    @NotEmpty
    private String content;

    @ApiModelProperty(value = "Blog post comments")
    private Set<CommentDto> comments;

}
