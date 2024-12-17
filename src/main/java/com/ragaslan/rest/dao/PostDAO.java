package com.ragaslan.rest.dao;

import com.ragaslan.rest.entity.Post;

import java.util.List;

public interface PostDAO {
    void save(Post post);
    Post findById(Integer id);
    List<Post> findAll();
    void update(Post post);
    void delete(Integer id);
}
