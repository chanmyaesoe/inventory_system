package net.javaguides.springboot.springboothelloworldtutorial.repository;

import net.javaguides.springboot.springboothelloworldtutorial.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.assertj.core.api.Assertions.assertThat;
//@SpringJUnitConfig(locations = "classpath:test-context.xml")
@SpringBootTest
@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    //    @Before
    @Test
    public void insertEmployee(){
        Employee emp = new Employee();
        emp.setEmail("chan@gmail.com");
        emp.setFirst_name("Chan");
        emp.setLast_name("Chan");
        employeeMapper.saveEmployee(emp);
    }



    @Test
    public void EmployeeGetAll() {
        List<Employee> list = employeeMapper.getAll(1,5);
        assertThat(list.size()).isGreaterThan(1);
    }
}
