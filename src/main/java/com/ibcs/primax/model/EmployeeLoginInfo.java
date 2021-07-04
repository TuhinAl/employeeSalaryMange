package com.ibcs.primax.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_login_info")
public class EmployeeLoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @OneToOne
    private Employee employee;


}

