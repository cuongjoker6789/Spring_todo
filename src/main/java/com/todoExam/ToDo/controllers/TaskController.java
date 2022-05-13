package com.todoExam.ToDo.controllers;

import com.todoExam.ToDo.models.Task;
import com.todoExam.ToDo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
  @Autowired
  TaskServices taskServices;
  @GetMapping
  public List<Task> getTask() {
    return taskServices.getTask();
  }
  @GetMapping("/{id}")
  private Task getTaskById(@PathVariable("id") Long id){
    return taskServices.getTaskByID(id);
  }

  @PostMapping
  public String savetask(@RequestBody Task task) {
    taskServices.saveTask(task);
    return "Task add success";
  }

  @PutMapping
  public String updateTask(@RequestBody Task task) {
    taskServices.updateTask((task));
    return " Task update success";
  }
  //cascade
  @DeleteMapping("/{id}")
  private void deleteTask(@PathVariable("id") Long id) {
    taskServices.deleteTask(id);
  }


}
