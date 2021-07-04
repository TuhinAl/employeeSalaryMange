package com.ibcs.primax.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column
    private String email;

    @Column
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address-id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private EmployeeAccount employeeAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_login_id", referencedColumnName = "id")
    private EmployeeLoginInfo employeeLoginInfo;







}
