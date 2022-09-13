package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Project;
import web.service.ProjectService;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService service;

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return service.getProjects();
    }

    @PostMapping("/projects")
    public List<Project> addProject(@RequestBody Project project) {
        service.add(project);
        return service.getProjects();
    }

    @GetMapping(value = "/project/{id}")
    public Project getProject(@PathVariable("id") long id) {
        return service.getProject(id);
    }

    @PatchMapping(value = "/projects")
    public List<Project> editProject(@RequestBody Project project) {
        service.update(project);
        return service.getProjects();
    }
}
