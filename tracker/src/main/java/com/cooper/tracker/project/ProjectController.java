package com.cooper.tracker.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {this.projectService = projectService;}

    @GetMapping
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @PostMapping
    public void registerNewProject(@RequestBody Project project){projectService.addNewProject(project);}

    @DeleteMapping(path = "{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId) {projectService.deleteProject(projectId);}

}
