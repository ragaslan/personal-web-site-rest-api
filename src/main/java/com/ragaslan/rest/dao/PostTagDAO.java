package com.ragaslan.rest.dao;


import com.ragaslan.rest.entity.PostTag;

import java.util.List;

public interface PostTagDAO {
    void save(PostTag postTag);
    PostTag findById(Integer id);
    PostTag findByName(String name);
    List<PostTag> findAll();
    void update(PostTag postTag);
    void delete(Integer id);
}
