package com.example.employee_task_api.controller;

import com.example.employee_task_api.model.AddTask;
import com.example.employee_task_api.repository.EmployeeTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddTaskControllerTest {

    @Mock
    private EmployeeTaskRepository employeeTaskRepository;

    @InjectMocks
    private AddTaskController addTaskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddTaskToEmployee() {
        AddTask addTask = new AddTask();
        addTask.setId(1L);
        addTask.setEmployeeId(1L);
        addTask.setTaskId(1L);

        when(employeeTaskRepository.save(addTask)).thenReturn(addTask);

        ResponseEntity<String> response = addTaskController.addTaskToEmployee(addTask);

        assertEquals("Task added successfully!", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}
