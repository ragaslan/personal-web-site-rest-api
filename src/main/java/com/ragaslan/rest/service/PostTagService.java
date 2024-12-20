package com.ragaslan.rest.service;


import com.ragaslan.rest.entity.PostTag;

import java.util.List;


public interface PostTagService {
    List<PostTag> findAll();
    PostTag findById(Integer id);
    PostTag create(PostTag thePostTag);
    void deleteById(Integer id);
    PostTag updateById(Integer id,PostTag thePostTag);

}
