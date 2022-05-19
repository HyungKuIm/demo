package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployService{

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        //return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        return employeeRepository.findAll();
    }
}
