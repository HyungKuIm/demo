package com.example.demo.repository.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Authorization {

    public enum Role {
        admin, staff, user
    }

    @Id
    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    // 사원
    @ManyToMany(mappedBy = "authorizationSet")
    private Set<Employee> employeeSet;
}
