package com.example.springtutorial.service;

import com.example.springtutorial.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(long id, Employee employee);
    boolean removeEmployee(long id);
    List<Employee> getAll();
    Employee getOneById(long id);

}
