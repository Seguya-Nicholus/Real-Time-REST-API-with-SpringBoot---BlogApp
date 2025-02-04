package com.codewith.springboot_blog_rest_api.repository;

import com.codewith.springboot_blog_rest_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
