package com.example.employee_task_api.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AddTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long taskId;
    private Long employeeId;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getTaskId() {return taskId;}
    public void setTaskId(Long taskId) {this.taskId = taskId;}
    public Long getEmployeeId() {return employeeId;}
    public void setEmployeeId(Long employeeId) {this.employeeId = employeeId;}
}


