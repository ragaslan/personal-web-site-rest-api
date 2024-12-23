package com.ragaslan.rest.service;

import com.ragaslan.rest.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Integer id);
    Project create(Project project);
    Project updateById(Integer id,Project project);
    void deleteById(Integer id);
}
