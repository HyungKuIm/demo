package com.example.demo.repository.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
//@Data
@Getter
@Setter
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

    @OneToOne(mappedBy = "employee")
    private Authentication authentication;

    @ManyToMany
    @JoinTable(
            name = "employeeAuthorization",
            joinColumns = @JoinColumn(name = "employeeNo"),
            inverseJoinColumns = @JoinColumn(name = "authorizationRole")
    )
    private Set<Authorization> authorizationSet;

}
