package com.ragaslan.rest.dao.impl;

import com.ragaslan.rest.dao.PostDAO;
import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.entity.PostTag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    private final EntityManager entityManager;

    @Autowired
    public PostDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Post post) {
        List<PostTag> tags = new ArrayList<>();
        post.setTags(tags);
        entityManager.persist(post);
    }

    @Override
    public Post findById(Integer id){
        return entityManager.find(Post.class, id);
    }

    @Override
    public List<Post> findAll(){
        TypedQuery<Post> query = entityManager.createQuery("from Post",Post.class);
        return query.getResultList();
    }

    @Override
    public void update(Post post){
        entityManager.merge(post);
    }

    @Override
    public void delete(Integer id){
        Post thePost = entityManager.find(Post.class,id);
        entityManager.remove(thePost);
    }
}
