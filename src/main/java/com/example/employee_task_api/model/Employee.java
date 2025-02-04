package com.example.employee_task_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate hireDate;
    private LocalDate dismissalDate;
    private String type;



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
    public LocalDate getDismissalDate() { return dismissalDate; }
    public void setDismissalDate(LocalDate dismissalDate) { this.dismissalDate = dismissalDate; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
