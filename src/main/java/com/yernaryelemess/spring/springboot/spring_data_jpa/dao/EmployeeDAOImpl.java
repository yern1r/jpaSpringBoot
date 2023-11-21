package com.yernaryelemess.spring.springboot.springboot.dao;

import com.yernaryelemess.spring.springboot.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;



    @Override
    public List<Employee> getAllEmployees() {

//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("from Employee"
//                , Employee.class);
//
//        List<Employee> allEmployees = query.getResultList();

         Query query =  entityManager.createQuery("from  Employee");
         List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);

        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int employer_id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class , employer_id);
        Employee employee = entityManager.find(Employee.class , employer_id);
        return employee;
    }

    @Override
    public void deleteEmployee(int employer_id) {

//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " +
//                "where employer_id =: employeeId");
//        query.setParameter("employeeId", employer_id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee " +
                "where employer_id =: employeeId");
        query.setParameter("employeeId", employer_id);
        query.executeUpdate();
    }
}
