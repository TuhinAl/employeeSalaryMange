package com.ibcs.primax.mapper.requestMapper;

import com.ibcs.primax.dto.requestDto.CompanyDTO;
import com.ibcs.primax.model.AccountType;
import com.ibcs.primax.model.Company;
import org.springframework.stereotype.Service;

/**
 * @author tuhin
 * @created_on 7/6/21 at 9:38 AM
 * @project primax
 **/
@Service
public class CompanyRequestMapping {

    public Company map(CompanyDTO dto) {
        Company company = new Company();

        company.setCompanyName(dto.getCompanyName());
        company.setCompanyBankAccountNumber(dto.getCompanyBankAccountNumber());
        company.setAccountType(AccountType.CURRENT);

        return company;
    }


}
