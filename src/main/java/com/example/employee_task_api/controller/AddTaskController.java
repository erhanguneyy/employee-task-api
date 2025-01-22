package com.example.employee_task_api.controller;

import com.example.employee_task_api.model.AddTask;
import com.example.employee_task_api.repository.EmployeeTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/add-task")
public class AddTaskController {

    @Autowired
    private EmployeeTaskRepository employeeTaskRepository;

    @PostMapping
    public ResponseEntity<String> addTaskToEmployee(@RequestBody AddTask addTask) {
        // Görevi veritabanına kaydet
        employeeTaskRepository.save(addTask);
        return ResponseEntity.ok("Task added successfully!");
    }
}
