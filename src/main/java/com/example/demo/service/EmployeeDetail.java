package com.example.demo.service;

import com.example.demo.repository.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class EmployeeDetail extends User {


    public EmployeeDetail(Employee employee) {
        super(employee.getAuthentication().getId(),
                employee.getAuthentication().getPassword(), true,
                employee.getAuthentication().getValidDate()
                        .toLocalDate().compareTo(LocalDate.now()) >= 0, true, true,
                        new ArrayList<>());
    }
}
