package com.ragaslan.rest.dao.impl;

import com.ragaslan.rest.dao.UserDAO;
import com.ragaslan.rest.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User findByUsername(String username) {
        try {
            TypedQuery<User> query = entityManager.createQuery("from User u where u.username = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User",User.class);
        return query.getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Integer id) {
        User theUser = entityManager.find(User.class,id);
        entityManager.remove(theUser);
    }
}
