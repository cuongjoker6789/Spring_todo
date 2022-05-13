package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServices {
 @Autowired
  private TaskRepository taskRepository;

  public List<Task> getTask() {
    return taskRepository.findAll();
  }

  public Task getTaskByID(Long id)
  {
    return taskRepository.findById(id).get();
  }
  public Task saveTask(Task task){
    return taskRepository.save(task);
  }


  public void deleteTask(Long id)
  {
    taskRepository.findById(id)
      .map((task) -> task.getId())
      .ifPresent(taskRepository::deleteById);

  }




  public void updateTask(Task task) {
    Task ts = taskRepository.findById(task.getId())
      .orElseThrow(RuntimeException::new)
      ;
    ts.setBody(task.getBody());
    ts.setTittle(task.getTittle());
  }

}
