package com.example.employee_task_api.controller;

import com.example.employee_task_api.model.AddTask;
import com.example.employee_task_api.model.Employee;
import com.example.employee_task_api.model.Task;
import com.example.employee_task_api.repository.EmployeeRepository;
import com.example.employee_task_api.repository.EmployeeTaskRepository;
import com.example.employee_task_api.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeTaskControllerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeTaskRepository employeeTaskRepository;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private EmployeeTaskController employeeTaskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEmployeeTasks() {
        // Mock verileri oluştur
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setHireDate(LocalDate.of(2023, 1, 1));

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setFirstName("Jane");
        employee2.setLastName("Smith");
        employee2.setHireDate(LocalDate.of(2022, 5, 15));

        Task task1 = new Task();
        task1.setId(1);
        task1.setTitle("Task 1");
        task1.setDescription("Task 1 Description");

        AddTask addTask = new AddTask();
        addTask.setId(1L);
        addTask.setEmployeeId(1L);
        addTask.setTaskId(1L);

        // Mock repository yanıtlarını ayarla
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));
        when(employeeTaskRepository.findAll()).thenReturn(Collections.singletonList(addTask));
        when(taskRepository.findAll()).thenReturn(Collections.singletonList(task1));

        // Controller metodunu çağır ve sonucu kontrol et
        List<Map<String, Object>> result = employeeTaskController.getEmployeeTasks();

        // Beklenen sonuçları doğrula
        assertEquals(2, result.size());
        assertEquals("John", ((Employee) result.get(0).get("employee")).getFirstName());
        assertEquals(1, ((List<?>) result.get(0).get("tasks")).size());
    }
}
