package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseBody
    public ResponseEntity<Object>  getAllEmployee(@RequestParam(defaultValue  = "0") Integer pageNum ,@RequestParam(defaultValue  = "0") Integer pageSize) { // gel all data
        List<Employee> list = employeeService.getAllEmployee(((pageNum -1) * pageSize), pageSize);
        Employee count = employeeService.getCount();
        Map<String, Long> pageInfo = new HashMap<String, Long>();
        pageInfo.put("pageSize", count.getId());
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, list, pageInfo);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> saveEmployee(Employee employee) { //create data
        try {
            Employee _employee = employeeService.saveEmployee(employee);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(Employee employee) { // updata data
        try {
            Employee _employee = employeeService.updateEmployee(employee);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable("id") int id) { // delete data
        try {
            Employee _employee = employeeService.deleteEmployeeById(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
