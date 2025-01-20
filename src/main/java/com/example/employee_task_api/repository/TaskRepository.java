package com.example.employee_task_api.repository;

import com.example.employee_task_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {}