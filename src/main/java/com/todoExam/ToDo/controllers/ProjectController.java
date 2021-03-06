package com.todoExam.ToDo.controllers;

import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
  @Autowired
  ProjectServices projectServices;
  @GetMapping
  public List<Project> getProject(){
    return projectServices.getProject();
  }
  @GetMapping("/id")
  private Project getProjectById(@PathVariable("id") Long id){
    return projectServices.getProjectByID(id);
  }
  @PostMapping
  public String saveProject(@RequestBody Project project){
    projectServices.saveProject((project));
    return "Project is add";
  }
  @PutMapping
  public String updateProject(@RequestBody Project project){
    projectServices.updateProject((project));
    return "Project is update";
  }
  @DeleteMapping("/{id}")
  private  void deleteProject(@PathVariable("id") Long id){
    projectServices.deleteProject(id);
  }
}
