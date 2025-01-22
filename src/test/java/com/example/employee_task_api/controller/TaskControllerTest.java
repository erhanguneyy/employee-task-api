package com.example.employee_task_api.controller;

import com.example.employee_task_api.model.Task;
import com.example.employee_task_api.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskControllerTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task();
        task.setId(1);
        task.setTitle("Task 1");

        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskController.createTask(task);

        assertEquals("Task 1", result.getTitle());
    }

    @Test
    public void testGetAllTasks() {
        Task task1 = new Task();
        task1.setId(1);
        task1.setTitle("Task 1");

        Task task2 = new Task();
        task2.setId(2);
        task2.setTitle("Task 2");

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> result = taskController.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Task 2", result.get(1).getTitle());
    }
}
