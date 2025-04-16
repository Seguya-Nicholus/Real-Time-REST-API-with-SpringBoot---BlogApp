package com.codewith.springboot_blog_rest_api.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter // Getters, 
@Setter //Setters
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

}
