package com.example.employee_task_api.controller;

import com.example.employee_task_api.model.Task;
import com.example.employee_task_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
