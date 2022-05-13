package com.todoExam.ToDo.repositorys;

import com.todoExam.ToDo.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRopository extends JpaRepository<Project, Long> {
}
