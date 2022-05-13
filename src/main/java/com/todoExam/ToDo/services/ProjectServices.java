package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.repositorys.ProjectRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProjectServices {
  @Autowired
  private ProjectRopository projectRopository;

  public List<Project> getProject() {
    return projectRopository.findAll();
  }

  public Project getProjectByID(Long id)
  {
    return projectRopository.findById(id).get();
  }
  public Project saveProject(Project project){
    return projectRopository.save(project);
  }


  public void deleteProject(Long id)
  {
    projectRopository.findById(id)
      .map((project) -> project.getId())
      .ifPresent(projectRopository::deleteById);

  }




  public void updateProject(Project project) {
    Project pj = projectRopository.findById(project.getId())
      .orElseThrow(RuntimeException::new)
      ;

     pj.setName(project.getName());
  }

}
