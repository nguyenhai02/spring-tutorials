package com.example.springtutorial.controller;

import com.example.springtutorial.model.Employee;
import com.example.springtutorial.service.EmployeeServiceImpl;
import com.example.springtutorial.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("") //
    public Employee addEmployee(@RequestBody Employee employee){
        return iEmployeeService.addEmployee(employee);
    }

    @PutMapping("") //
    public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee){
        return iEmployeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}") // không cần "delete"
    public boolean deleteEmployee(@PathVariable("id") long id) {
        return iEmployeeService.removeEmployee(id);
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return iEmployeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Long id) {
        return iEmployeeService.getOneById(id);
    }
}
