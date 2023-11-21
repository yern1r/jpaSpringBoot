package com.yernaryelemess.spring.springboot.spring_data_jpa.controller;


import com.yernaryelemess.spring.springboot.spring_data_jpa.entity.Employee;
import com.yernaryelemess.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);

//        if (employee==null){
//            throw new NoSuchEmployeeException("There is no employee with ID = "
//                    + id + " in DataBase." );
//        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){

         employeeService.saveEmployee(employee);
         return employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

//        Employee employee = employeeService.getEmployee(id);
//        if (employee==null){
//            throw new NoSuchEmployeeException("There is no employee with id "
//                    + id + " in Database");
//        }

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){
        List<Employee> employeeListByName = employeeService.findAllByName(name);
        return employeeListByName;
    }
}
