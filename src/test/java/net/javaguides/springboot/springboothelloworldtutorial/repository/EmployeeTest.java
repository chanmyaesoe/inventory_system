package net.javaguides.springboot.springboothelloworldtutorial.repository;

import junit.framework.Assert;

import net.javaguides.springboot.springboothelloworldtutorial.mapper.EmployeeMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private EmployeeMapper employeeMapper;

//    @Before
//    public void insertEmployee(){
//        Employee emp = new Employee();
//        emp.setEmpid(1);
//        emp.setFirstName("Manik");
//        emp.setLastName("Magar");
//        employeeMapper.saveEmployee(emp);
//    }
@Test
    public void firstTest() {
        assumeTrue(5 > 1);
    }

    @Test
    public void testEmployee(){
        System.out.println("testEmployee");
        List<Employee> employees = employeeMapper.getAll();
        Assertions.assertThat(1).isGreaterThan(1);
    }

}
