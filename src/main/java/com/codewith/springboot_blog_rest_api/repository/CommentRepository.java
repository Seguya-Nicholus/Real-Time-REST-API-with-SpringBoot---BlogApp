package com.codewith.springboot_blog_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewith.springboot_blog_rest_api.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);

}
