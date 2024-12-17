package com.ragaslan.rest.service;

import com.ragaslan.rest.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Integer id);
    Post create(Post thePost);
    void deleteById(Integer id);
    Post updateById(Integer id,Post thePost);
}
