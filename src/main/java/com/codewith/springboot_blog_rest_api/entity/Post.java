package com.codewith.springboot_blog_rest_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Getters, Setters, Tostring,
@AllArgsConstructor  // All argument constructor
@NoArgsConstructor   // No argument constructor

@Entity
@Table(
        name="posts", uniqueConstraints = {@UniqueConstraint(columnNames={"title"})}
) // Setting a unique column in the table and a table name
public class Post {

    @Id  // primary key
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) // primary key generation strategy
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

}
