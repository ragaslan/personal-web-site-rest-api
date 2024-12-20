package com.ragaslan.rest.dao.impl;

import com.ragaslan.rest.dao.PostTagDAO;
import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.entity.PostTag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostTagDAOImpl implements PostTagDAO {

    private final EntityManager entityManager;

    @Autowired
    public PostTagDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(PostTag postTag) {
        entityManager.persist(postTag);
    }

    @Override
    public PostTag findById(Integer id){
        return entityManager.find(PostTag.class, id);
    }

    @Override
    public PostTag findByName(String name){
        try{
            TypedQuery<PostTag> query = entityManager.createQuery("select tag from PostTag tag where tag.name = :tagName",PostTag.class);
            query.setParameter("tagName",name);
            return query.getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
    @Override
    public List<PostTag> findAll(){
        TypedQuery<PostTag> query = entityManager.createQuery("from PostTag",PostTag.class);
        return query.getResultList();
    }

    @Override
    public void update(PostTag postTag){
        entityManager.merge(postTag);
    }

    @Override
    public void delete(Integer id){
        PostTag thePostTag = entityManager.find(PostTag.class,id);
        entityManager.remove(thePostTag);
    }

}
