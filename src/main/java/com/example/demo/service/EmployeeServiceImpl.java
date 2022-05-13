package com.example.demo.service;

import com.example.demo.repository.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployeeLIst() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }
}
