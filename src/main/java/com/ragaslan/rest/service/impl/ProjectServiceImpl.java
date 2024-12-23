package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.ProjectDAO;
import com.ragaslan.rest.entity.Project;
import com.ragaslan.rest.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDAO projectDAO;

    public ProjectServiceImpl(ProjectDAO projectDAO){
        this.projectDAO = projectDAO;
    }


    @Override
    public List<Project> findAll() {
       return projectDAO.findAll();
    }

    @Override
    public Project findById(Integer id) {
        Project project = projectDAO.findById(id);
        if (project == null){
            throw new RuntimeException("There is no project with this id !");
        }
        return project;
    }

    @Transactional
    @Override
    public Project create(Project project){
        projectDAO.save(project);
        return project;
    }

    @Transactional
    @Override
    public Project updateById(Integer id, Project project) {
        Project originalProject = projectDAO.findById(id);
        if (originalProject == null){
            throw new RuntimeException("There is no project with this id !");
        }
        originalProject.setContent(project.getContent());
        originalProject.setName(project.getName());
        originalProject.setIntroduction(project.getIntroduction());
        originalProject.setGithubLink(project.getGithubLink());
        projectDAO.update(originalProject);
        return originalProject;
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        Project project = projectDAO.findById(id);
        if (project == null){
            throw new RuntimeException("There is no project with this id !");
        }
        projectDAO.delete(id);
    }


}
