package com.codewith.springboot_blog_rest_api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.binder.internal.CommentsBinder;
import org.springframework.stereotype.Service;

import com.codewith.springboot_blog_rest_api.entity.Comment;
import com.codewith.springboot_blog_rest_api.entity.Post;
import com.codewith.springboot_blog_rest_api.exception.ResourceNotFoundException;
import com.codewith.springboot_blog_rest_api.payload.CommentDto;
import com.codewith.springboot_blog_rest_api.repository.CommentRepository;
import com.codewith.springboot_blog_rest_api.repository.PostRepository;
import com.codewith.springboot_blog_rest_api.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        
        Comment comment = mapToEntity(commentDto);

        //retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));

        //set post to comment entity
        comment.setPost(post);

        // comment entity to DB
        Comment newComment = commentRepository.save(comment);

        return mapToDTO(newComment);
    }


    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        // convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    private CommentDto mapToDTO(Comment comment){

        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());

        return commentDto;
    }


    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;
    }


    

}
