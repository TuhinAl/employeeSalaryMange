package com.ibcs.primax.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "company_infos")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_bank_account_number")
    private String companyBankAccountNumber;

    @Column(name = "account_type")
    private AccountType accountType;
}
