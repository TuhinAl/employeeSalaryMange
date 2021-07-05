package com.ibcs.primax.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_account")
public class EmployeeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @Column(name = "employee_account_id", nullable = false)
    private String employeeIds;

   /* @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "branch_name", nullable = false)
    private String branchName;*/

    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "basic_salary", nullable = false)
    private Double basicSalary;

    @Column(name = "home_rent", nullable = false)
    private Double homeRent;

    @Column(name = "medical_allowance", nullable = false)
    private Double medicalAllowance;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
