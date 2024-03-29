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

/*
    @Column(name = "employee_account_id", nullable = false)
    private Long employeeIds;*/

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

    @Column(name = "account_balance", nullable = false)
    private Double accountBalance;

    @Column(name = "medical_allowance", nullable = false)
    private Double medicalAllowance;

    @OneToOne(mappedBy = "employeeAccount")
    private Employee employee;
}
