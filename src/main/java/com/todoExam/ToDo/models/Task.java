package com.todoExam.ToDo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "tittle")
  private String tittle;
  @Column(name = "body")
  private String body;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="project_id", referencedColumnName = "id")
  @JsonBackReference
  private Project project;
}
