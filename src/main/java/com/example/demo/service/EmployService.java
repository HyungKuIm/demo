package com.example.demo.service;

import com.example.demo.repository.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployService {
    Page<Employee> getEmployeeList(Pageable pageable);

    long getEmployeeCnt();
}
