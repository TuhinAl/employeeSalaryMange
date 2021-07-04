package com.ibcs.primax.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "bank_name")
    private String bankName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_ids", referencedColumnName = "id")
    private List<Employee> employees = new ArrayList<>();

}
