package com.example.demo.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Employee implements Serializable {

    public enum Sex {
        male, female
    }

    @Id
    private Integer no;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Date birthday;

    @Column(unique = true)
    private String mailAddress;

}
