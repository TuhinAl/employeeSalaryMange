package com.ibcs.primax.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column
    private Date accountCreateDate;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
    mappedBy = "bank"
    )
    /*@JoinColumn(name = "em_id", referencedColumnName = "id")*/
    private List<Employee> employee = new ArrayList<>();

}
