package com.example.demo.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Authentication {

    @Id
    private String id;

    private String password;

    private java.sql.Date validDate;


    @OneToOne
    //@JoinColumn(name = "employeeNo")
    private Employee employee;
}
