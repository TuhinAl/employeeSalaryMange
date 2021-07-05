package com.ibcs.primax.dto.requestDto;

import com.ibcs.primax.model.AccountType;

import java.util.Date;

public class CompanyDTO {
    private Integer id;
    private String companyName;
    private String companyBankAccountNumber;
    private AccountType accountType;
    private Date createDate;
}
