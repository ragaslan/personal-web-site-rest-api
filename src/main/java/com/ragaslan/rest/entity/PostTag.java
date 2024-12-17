package com.ragaslan.rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class PostTag {

    @Id
    public int id;

    @Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "post_id")
    public Post post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
