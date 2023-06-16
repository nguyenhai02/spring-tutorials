package com.example.springtutorial.service;

import com.example.springtutorial.model.Employee;
import com.example.springtutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        if(employee != null) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if(employee != null) {
            Employee employee1 = employeeRepository.getById(id);
            if(employee1 != null) {
                employee1.setName(employee.getName());
                employee1.setAddress(employee.getAddress());
                return employeeRepository.save(employee1);
            }
            return employee1;
        }
        return null;
    }

    @Override
    public boolean removeEmployee(long id) {
        if(id >= 1) {
            Optional<Employee> employeeOptional = employeeRepository.findById(id);
            if(employeeOptional.isPresent()) {
                employeeRepository.delete(employeeOptional.get());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOneById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }
}
