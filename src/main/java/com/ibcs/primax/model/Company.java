package com.ibcs.primax.model;

import lombok.Data;


@Data
public class Company {

    private Integer id;
    private String companyName;
    private String companyBankAccountNumber;
    private AccountType accountType;
}
