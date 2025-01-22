package com.example.employee_task_api.repository;

import com.example.employee_task_api.model.Employee;
import com.example.employee_task_api.model.AddTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTaskRepository extends JpaRepository<AddTask, Long> {}
