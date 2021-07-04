package com.ibcs.primax.model;

import lombok.Data;

@Data
public class EmployeeAccount {

    private Integer id;
    private String employeeId;
    private String gradeType;
    private String bankName;
    private String branchName;
    private AccountType accountType;
    private Long basicSalary;
    private Long homeRent;
    private Long medicalAllowance;
}
