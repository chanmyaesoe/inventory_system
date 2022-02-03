package net.javaguides.springboot.springboothelloworldtutorial.service.impl;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();
    public Employee saveEmployee(Employee employee);
    public Employee deleteEmployeeById(Integer id);
    public Employee updateEmployee(Employee employee);

}