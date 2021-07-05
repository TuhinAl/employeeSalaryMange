package com.ibcs.primax.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankInfoDTO {
    private String accountType;
    private String accountName;
    private Double currentBalance;
    private String branchName;
    private String bankName;
    private Date createDate;
}
