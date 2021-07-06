package com.ibcs.primax.dto.requestDto;

import com.ibcs.primax.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private Integer id;
    private String companyName;
    private String companyBankAccountNumber;
    private AccountType accountType;
    private Double companyCurrentBalance;
    private Date createDate;
}
