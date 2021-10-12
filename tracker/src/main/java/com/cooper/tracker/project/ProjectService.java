package com.cooper.tracker.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projRepository){this.projectRepository = projRepository;}

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public void addNewProject(Project project){
        Optional<Project> projectOptional = projectRepository.findProjectByName(project.getName());
        if(projectOptional.isPresent()){
            throw new IllegalStateException("project does not have unique name");
        }
        projectRepository.save(project);

    }

    public void deleteProject(Long projectId) {
        boolean exists = projectRepository.existsById(projectId);
        if(!exists) {
            throw new IllegalStateException("project with id " + projectId + " does not exist");
        }
        projectRepository.deleteById(projectId);
    }

}
