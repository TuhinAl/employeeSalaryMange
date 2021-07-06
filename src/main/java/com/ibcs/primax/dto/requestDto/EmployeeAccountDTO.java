package com.ibcs.primax.dto.requestDto;

import com.ibcs.primax.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAccountDTO {

    private Long employeeId;
    private AccountType accountType;
    private Double basicSalary;
    private Double homeRent;
    private Double medicalAllowance;
    private Double accountBalance;
    private Date createDate;
}
