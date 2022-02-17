package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public List<Employee> getAll(Integer pageNum, Integer pageSize);

    public void saveEmployee(Employee employee);

    public void deleteEmployeeById(Integer id);

    public void updateEmployee(Employee employee);

    public  Employee getCount();
}
