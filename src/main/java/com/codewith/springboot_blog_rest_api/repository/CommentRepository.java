package com.codewith.springboot_blog_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewith.springboot_blog_rest_api.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
