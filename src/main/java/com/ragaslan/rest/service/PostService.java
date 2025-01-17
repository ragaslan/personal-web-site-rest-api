package com.ragaslan.rest.service;

import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.entity.PostTag;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Integer id);
    Post create(Post thePost);
    Post findBySlug(String slug);
    void deleteById(Integer id);
    Post updateById(Integer id,Post thePost);
    List<PostTag> getAllTags(Integer id);
    List<PostTag> addTag(Integer id,PostTag theTag);
}
