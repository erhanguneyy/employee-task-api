package com.example.employee_task_api.controller;

import com.example.employee_task_api.model.AddTask;
import com.example.employee_task_api.model.Employee;
import com.example.employee_task_api.model.Task;
import com.example.employee_task_api.repository.EmployeeRepository;
import com.example.employee_task_api.repository.EmployeeTaskRepository;
import com.example.employee_task_api.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee-task")
public class EmployeeTaskController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeTaskRepository employeeTaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Map<String, Object>> getEmployeeTasks() {
        List<Employee> employees = employeeRepository.findAll();
        List<AddTask> addTasks = employeeTaskRepository.findAll();
        List<Task> tasks = taskRepository.findAll();

        // Çalışan bilgilerini ve görevlerini birleştiren bir liste oluşturma
        List<Map<String, Object>> result = new ArrayList<>();
        for (Employee employee : employees) {
            Map<String, Object> employeeData = new HashMap<>();
            employeeData.put("employee", employee);

            // Çalışanın atanmış görevlerini filtreleme
            List<Task> assignedTasks = addTasks.stream()
                    .filter(at -> at.getEmployeeId().equals(employee.getId()))
                    .map(at -> tasks.stream()
                            .filter(task -> task.getId() == at.getTaskId())
                            .findFirst()
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            employeeData.put("tasks", assignedTasks);
            result.add(employeeData);
        }
        return result;
    }
}
