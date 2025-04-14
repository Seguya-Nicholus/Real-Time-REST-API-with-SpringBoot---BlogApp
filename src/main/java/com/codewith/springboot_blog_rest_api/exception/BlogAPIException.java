package com.codewith.springboot_blog_rest_api.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{

    private HttpStatus status;
    private String message;


    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


    public BlogAPIException(HttpStatus status, String message, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus geStatus(){
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
