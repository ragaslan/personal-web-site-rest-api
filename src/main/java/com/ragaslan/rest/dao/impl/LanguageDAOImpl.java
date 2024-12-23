package com.ragaslan.rest.dao.impl;

import com.ragaslan.rest.dao.LanguageDAO;
import com.ragaslan.rest.entity.Language;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class LanguageDAOImpl implements LanguageDAO {

    private final EntityManager entityManager;

    public LanguageDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Language lang){
        entityManager.persist(lang);
    }

    @Override
    public void delete(Integer id){
        Language theLang = entityManager.find(Language.class,id);
        entityManager.remove(theLang);
    }

    @Override
    public Language findById(Integer id){
        return entityManager.find(Language.class,id);
    }

    @Override
    public List<Language> findAll(){
        TypedQuery<Language> q = entityManager.createQuery("from Language",Language.class);
        return q.getResultList();
    }

    @Override
    public List<Language> findAllTools(){
        TypedQuery<Language> q = entityManager.createQuery("from Language l where l.isTool = true",Language.class);
        return q.getResultList();
    }

    @Override
    public void update(Language lang){
        entityManager.merge(lang);
    }
}
