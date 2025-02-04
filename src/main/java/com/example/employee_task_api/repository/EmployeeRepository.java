package com.example.employee_task_api.repository;

import com.example.employee_task_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
