package com.ibcs.primax.mapper.requestMapper;

import com.ibcs.primax.dto.requestDto.BankInfoDTO;
import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.model.AccountType;
import com.ibcs.primax.model.Bank;
import com.ibcs.primax.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BankInfoRequestMapping {


    public Bank bankMap(BankInfoDTO dto) {

        Bank bankInfo = new Bank();
        bankInfo.setBankName(dto.getBankName());
        bankInfo.setBranchName(dto.getBranchName());
        bankInfo.setCurrentBalance(dto.getCurrentBalance());
        bankInfo.setAccountName(dto.getAccountName());
        bankInfo.setAccountType(AccountType.CURRENT);
        bankInfo.setAccountCreateDate(new Date());

        return bankInfo;
    }

}
