package com.ragaslan.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tag")
@Data
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name",unique = true)
    public String name;

    @ManyToMany
    @JsonIgnoreProperties("tags")
    @JoinTable(
            name = "tags_posts",
            joinColumns = { @JoinColumn(name = "post_tag_id")},
            inverseJoinColumns = { @JoinColumn(name = "post_id") }
    )
    public List<Post> posts;


}
