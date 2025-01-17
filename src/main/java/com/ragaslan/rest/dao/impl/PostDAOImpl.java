package com.ragaslan.rest.dao.impl;

import com.github.slugify.Slugify;
import com.ragaslan.rest.dao.PostDAO;
import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.entity.PostTag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Repository
public class PostDAOImpl implements PostDAO {

    private final EntityManager entityManager;
    //private final Slugify slugCreater;

    @Autowired
    public PostDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        //this.slugCreater = Slugify.builder().lowerCase(true).build();
    }

    @Override
    public void save(Post post) {
        List<PostTag> tags = new ArrayList<>();
        post.setTags(tags);
        Locale trlocale= Locale.of("tr","TR");
        Slugify slugCreater = Slugify.builder().lowerCase(true).locale(trlocale).build();
        String slugTitle = slugCreater.slugify(post.getTitle());
        Long timeForSlug = new Date().getTime();
        String slugTime = timeForSlug.toString();
        String newSlugTitle = slugTitle + "-" + slugTime;
        post.setSlug(newSlugTitle);
        entityManager.persist(post);
    }

    @Override
    public Post findById(Integer id){
        return entityManager.find(Post.class, id);
    }

    @Override
    public Post findBySlug(String slug){
        try{
            TypedQuery<Post> q = entityManager.createQuery("from Post where slug = :slugTitle",Post.class);
            q.setParameter("slugTitle",slug);
            return q.getSingleResult();
        }catch (NoResultException exception){
            return null;
        }

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
