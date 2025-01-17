package com.ragaslan.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "title")
    public String title;

    @Column(name = "content")
    @Length(max = 10000)
    public String content;

    @Column(name = "author")
    public String author;

    @Column(name = "created_at")
    public String createdAt;

    @Column(name = "slug",unique = true)
    public String slug;


    @JsonIgnoreProperties("posts")
    @ManyToMany(mappedBy = "posts")
    private List<PostTag> tags;

}
