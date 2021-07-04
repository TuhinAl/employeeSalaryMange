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
    private Integer id;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "employee_grade_type")
    private String gradeType;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "basic_salary")
    private Long basicSalary;

    @Column(name = "home_rent")
    private Long homeRent;

    @Column(name = "medical_allowance")
    private Long medicalAllowance;

    @OneToOne
    private Employee employee;
}
