package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.EmployeeMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee(Integer pageNum, Integer pageSize) {
        List<Employee> list = employeeMapper.getAll(pageNum, pageSize);
        return list;
    }

    @Override
    public Employee getCount() {
        Employee totalCount  = employeeMapper.getCount();
        return totalCount;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeMapper.saveEmployee(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployeeById(Integer id) {
        employeeMapper.deleteEmployeeById(id);
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }
}
