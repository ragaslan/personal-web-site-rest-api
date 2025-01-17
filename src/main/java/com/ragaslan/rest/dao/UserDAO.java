package com.ragaslan.rest.dao;

import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User findById(Integer id);
    User findByUsername(String username);
    List<User> findAll();
    void update(User user);
    void delete(Integer id);
}
