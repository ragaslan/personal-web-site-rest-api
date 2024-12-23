package com.ragaslan.rest.dao.impl;

import com.ragaslan.rest.dao.ProjectDAO;
import com.ragaslan.rest.entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {


    private final EntityManager entityManager;

    @Autowired
    public ProjectDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Project project){
        entityManager.persist(project);
    }

    @Override
    public Project findById(Integer id) {
        return entityManager.find(Project.class,id);
    }

    @Override
    public List<Project> findAll() {
        TypedQuery<Project> query = entityManager.createQuery("from Project",Project.class);
        return query.getResultList();
    }

    @Override
    public void delete(Integer id) {
        Project project = entityManager.find(Project.class,id);
        entityManager.remove(project);
    }

    @Override
    public void update(Project project) {
        entityManager.merge(project);
    }
}
