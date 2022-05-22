package com.example.demo.service;

import com.example.demo.repository.entity.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class EmployeeDetail extends User {


    public EmployeeDetail(Employee employee) {
        super(employee.getAuthentication().getId(),
                employee.getAuthentication().getPassword(), true,
                employee.getAuthentication().getValidDate()
                        .toLocalDate().compareTo(LocalDate.now()) >= 0, true, true,
                    employee.getAuthorizationSet().stream()
                            .map(a -> new SimpleGrantedAuthority(a.getRole().name())).collect(Collectors.toList())
                );
    }
}
