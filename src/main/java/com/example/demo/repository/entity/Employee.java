package com.example.demo.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
public class Employee implements Serializable {

    public enum Sex {
        male, female
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "employeeNoGenerator")
    @SequenceGenerator(name="employeeNoGenerator", sequenceName = "emp_no_seq", allocationSize = 1)
    private Integer no;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    private java.sql.Date birthday;

    @Column(unique = true)
    private String mailAddress;

}
