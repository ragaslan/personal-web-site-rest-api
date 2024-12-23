package com.ragaslan.rest.controller;


import com.ragaslan.rest.entity.Project;
import com.ragaslan.rest.service.ProjectService;
import com.ragaslan.rest.dto.ProjectDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Project>> findAll(){
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findOne(@PathVariable Integer id){
        Project project = projectService.findById(id);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Project> create(@Valid @RequestBody ProjectDTO projectDTO){
        ModelMapper mapper = new ModelMapper();
        Project project = mapper.map(projectDTO,Project.class);
        Project createdProject = projectService.create(project);
        return new ResponseEntity<>(createdProject,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        projectService.deleteById(id);
        return new ResponseEntity<>("Project is deleted successfully !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Integer id,@Valid @RequestBody ProjectDTO projectDTO){
        ModelMapper mapper = new ModelMapper();
        Project project = mapper.map(projectDTO,Project.class);
        Project updatedProject = projectService.updateById(id,project);
        return new ResponseEntity<>(updatedProject,HttpStatus.OK);
    }

}
