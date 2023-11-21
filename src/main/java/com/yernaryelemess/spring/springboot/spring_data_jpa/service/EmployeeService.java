package com.yernaryelemess.spring.springboot.springboot.service;



import com.yernaryelemess.spring.springboot.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee>  getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int employer_id);

    public  void  deleteEmployee(int employer_id);

}
