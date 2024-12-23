package com.ragaslan.rest.dao;

import com.ragaslan.rest.entity.Project;

import java.util.List;

public interface ProjectDAO {
    void save(Project project);
    List<Project> findAll();
    Project findById(Integer id);
    void update(Project project);
    void delete(Integer id);
}
